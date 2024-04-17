package n1exercise5;

import java.io.Serializable;

class FileData implements Serializable {
    private final String name;
    private final String type;
    private final String modificationDate;

    public FileData(String name, String type, String modificationDate) {
        this.name = name;
        this.type = type;
        this.modificationDate = modificationDate;
    }

    @Override
    public String toString() {
        return "FileData [name=" + name + ", type=" + type + ", modificationDate=" + modificationDate + "]";
    }
}

