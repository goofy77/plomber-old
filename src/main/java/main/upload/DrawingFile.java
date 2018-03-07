package main.upload;


import org.springframework.data.annotation.Id;

public class DrawingFile {

    @Id
    private String pdfDrawingId;

    private byte[] content;

    public DrawingFile() {}

    public DrawingFile(byte[] content) {
        this.content = content;
    }

    public byte[] getContent() {
        return content;
    }

    public String getPdfDrawingId() {
        return pdfDrawingId;
    }
}
