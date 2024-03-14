package raul.SGTTP.Model.repository;

import raul.SGTTP.Model.domain.Employed;
import raul.SGTTP.shared.filejsonadapter.FileJsonAdapter;

public class EmployedRepository {
    private FileJsonAdapter<EmployedEntity> fileJson;
    private String pathFile;

    public EmployedRepository(String pathFile) {
        this.pathFile = pathFile;
        fileJson = FileJsonAdapter.getInstance();
    }

    public Employed getEmployed(String id) {
        EmployedEntity[] employedEntities = fileJson.getObjects(pathFile, EmployedEntity[].class);
        for (EmployedEntity employedEntity : employedEntities) {
            if (employedEntity.id.equals(id)) {
                return new Employed(employedEntity.names, employedEntity.lastNames, null, employedEntity.id);
            }
        }
        return Employed.getNullEmpleado();
    }
}
