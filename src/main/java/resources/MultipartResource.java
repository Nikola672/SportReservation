package resources;


import jakarta.ws.rs.Produces;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.EntityExample;
import repository.MultipartRepository;

import java.nio.file.Files;

import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;




@jakarta.ws.rs.Path("/documents/") 
public class MultipartResource {


	@Inject
    MultipartRepository multipartRepository;

    @POST
    @jakarta.ws.rs.Path("upload")    
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadDocument(
            @QueryParam("entityId") Long entityId,
            @FormParam("file") java.io.File file,
            @FormParam("filename") String filename) {

        try {
            String savedName = multipartRepository.saveFile(entityId, file, filename);
            return Response.ok("Fajl '" + savedName + "' uspješno sačuvan").build();

        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();

        } catch (Exception e) {
            return Response.serverError().entity("Greška pri čuvanju fajla: " + e.getMessage()).build();
        }
    }

    @GET
    @jakarta.ws.rs.Path("/{id}/file")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response downloadFile(@PathParam("id") Long entityId) {
        EntityExample entity = multipartRepository.getEntityWithFile(entityId);
        if (entity == null || entity.getFilePath() == null) {
            return Response.status(404).entity("Entitet ili fajl nije pronađen").build();
        }

        java.nio.file.Path filePath = java.nio.file.Paths.get(entity.getFilePath());
        if (!Files.exists(filePath)) {
            return Response.status(404).entity("Fajl nije pronađen na serveru").build();
        }

        return Response.ok(filePath.toFile())
                .header("Content-Disposition", "attachment; filename=\"" + filePath.getFileName() + "\"")
                .build();
    }

    @Schema(type = SchemaType.STRING, format = "binary")
    public static class UploadSchema {}
}