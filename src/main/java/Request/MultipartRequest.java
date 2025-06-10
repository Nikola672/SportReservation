package Request;

import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.jboss.resteasy.reactive.PartType;
import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.multipart.FileUpload;

import jakarta.ws.rs.core.MediaType;

public class MultipartRequest {
    @RestForm("file")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    @Schema(type = SchemaType.STRING, format = "binary", description = "File to upload")
    private FileUpload file;

    @RestForm("name") 
    @PartType(MediaType.TEXT_PLAIN) 
    private String name;

    public FileUpload getFile() {
        return file;
    }

    public void setFile(FileUpload file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
	
}