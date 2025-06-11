package repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import model.EntityExample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Dependent   
public class MultipartRepository {
	
	 @Inject
	    EntityManager entityManager;   
	
	 @Transactional
	    public String saveFile(Long entityId, java.io.File file, String filename) throws IOException {
	        if (entityId == null || file == null || filename == null || filename.isBlank()) {
	            throw new IllegalArgumentException("Nedostaju parametri");
	        }

	        EntityExample entity = entityManager.find(EntityExample.class, entityId);
	        if (entity == null) {
	            throw new IllegalArgumentException("Entitet nije pronađen");
	        }

	        Path uploadDir = Path.of("uploads");
	        Files.createDirectories(uploadDir);

	        String safeFilename = sanitizeFilename(filename);
	        String uniqueName = UUID.randomUUID() + "_" + safeFilename;
	        Path targetPath = uploadDir.resolve(uniqueName);

	        Files.copy(file.toPath(), targetPath, StandardCopyOption.REPLACE_EXISTING);

	        entity.setFilePath(targetPath.toString());
	        entityManager.merge(entity);

	        return safeFilename;
	    }

	    public EntityExample getEntityWithFile(Long entityId) {
	        return entityManager.find(EntityExample.class, entityId);
	    }

	    private String sanitizeFilename(String filename) {
	        return filename.replace("..", "").replace("/", "").replace("\\", "").trim();
	    }
	
}
