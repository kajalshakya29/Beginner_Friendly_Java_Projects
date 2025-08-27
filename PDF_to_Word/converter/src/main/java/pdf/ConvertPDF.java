package pdf;

import com.spire.pdf.*;

public class ConvertPDF {
    public static void main(String[] args) {

        //Create a PdfDocument object
        PdfDocument doc = new PdfDocument();
        //Load the sample PDF file
        doc.loadFromFile("C:\\Users\\HP\\Downloads\\Javacore.pdf");

        //Save as .doc file
        doc.saveToFile("output/ToDoc.doc",FileFormat.DOC);

        //Save as. docx file
        doc.saveToFile("output/ToDocx.docx",FileFormat.DOCX);
        doc.close();
    }
}