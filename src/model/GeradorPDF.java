package model;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lalaine
 */
public class GeradorPDF {
    
    public GeradorPDF(){
        
    }
    
    public void gerarPDF(List<Prontuario> allProntuarios){
        Document doc = new Document();
        try {
            PdfWriter writer  = PdfWriter.getInstance(doc, new FileOutputStream(System.getProperty("user.home")+ "/RelatorioProntuario"+ new Date().toString()));
            doc.open();
            doc.add(new Paragraph("Relatorio Prontuarios", FontFactory.getFont(FontFactory.HELVETICA, 18, Font.ITALIC)));
            
            PdfPTable table = new PdfPTable(6);
            table.setWidthPercentage(100); //Width 100%
            table.setSpacingBefore(10f); //Space before table
            table.setSpacingAfter(10f); //Space after table
            
            float[] columnWidths = {1f, 1f, 1f, 1f, 1f, 1f};
            table.setWidths(columnWidths);
            
            
            PdfPCell cellID = new PdfPCell(new Paragraph("ID"));
            PdfPCell cellPET = new PdfPCell(new Paragraph("Nome do Animal"));
            PdfPCell cellVET = new PdfPCell(new Paragraph("Nome do Veterinario"));
            PdfPCell cellData = new PdfPCell(new Paragraph("Data do Prontuario"));
            PdfPCell cellOBS = new PdfPCell(new Paragraph("Observaçao"));
            PdfPCell cellSTATUS = new PdfPCell(new Paragraph("Ja realizado"));
            table.addCell(cellID);
            table.addCell(cellPET);
            table.addCell(cellVET);
            table.addCell(cellData);
            table.addCell(cellOBS);
            table.addCell(cellSTATUS);
            
            for(int i = 0; i <allProntuarios.size(); i++){
                
                PdfPCell cellIDTXT = new PdfPCell(new Paragraph(allProntuarios.get(i).getIdprontuario().toString()));
                PdfPCell cellPETTXT = new PdfPCell(new Paragraph(allProntuarios.get(i).getPet().getDescricao()));
                PdfPCell cellVETTXT = new PdfPCell(new Paragraph(allProntuarios.get(i).getVeterinario().getUsuario().getNome()));
                PdfPCell cellDataTXT = new PdfPCell(new Paragraph(allProntuarios.get(i).getData().toString()));
                PdfPCell cellOBSTXT = new PdfPCell(new Paragraph(allProntuarios.get(i).getObservacao()));
                PdfPCell cellSTATUSTXT = new PdfPCell(new Paragraph(allProntuarios.get(i).getRealizado() == true ? "SIM" : "NAO"));
                table.addCell(cellIDTXT);
                table.addCell(cellPETTXT);
                table.addCell(cellVETTXT);
                table.addCell(cellDataTXT);
                table.addCell(cellOBSTXT);
                table.addCell(cellSTATUSTXT);
                
                
            }
            
            doc.add(table);
            doc.close();
            writer.close();
            
            
        } catch (Exception ex) {
            Logger.getLogger(GeradorPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
