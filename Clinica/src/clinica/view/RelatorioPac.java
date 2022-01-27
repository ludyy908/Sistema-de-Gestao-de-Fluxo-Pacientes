
package clinica.view;

import clinica.model.Cirurgia;
import clinica.model.Consulta;
import com.itextpdf.io.image.*;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.*;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.*;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import java.io.*;
import java.awt.Desktop;
import java.net.MalformedURLException;
import java.util.*;
/**
 *
 * @author Amarilda Chihepe
 */
public class RelatorioPac {
    
    
    static Paragraph p,p1, p2, p3,p4, p5, p6, p7, p8;

    public RelatorioPac() {
        
    }
     
    
     public void gerarRelatorio(String n, String idp, String nP, String gp, String morp, String idadp, String biP,String civilp, String nacioP, String telp,
             String telAlt, String apelip, ArrayList<Consulta> listCons, ArrayList<Cirurgia> listCir) 
             throws FileNotFoundException, MalformedURLException, IOException{
        
        PdfWriter pw = new PdfWriter("Relatorio do(a) paciente "+n+".pdf");
        PdfDocument pdfDoc = new PdfDocument(pw);
        pdfDoc.setDefaultPageSize(PageSize.A4);
        pdfDoc.addNewPage();       
        Document doc = new Document(pdfDoc);
        
        ImageData imgD = ImageDataFactory.create("iconeprincipal.png");
        imgD.setWidth(50);
        imgD.setHeight(50);              
        Image img = new Image(imgD);
        img.setHorizontalAlignment(HorizontalAlignment.CENTER);
        
        
        p = new Paragraph("CLINICA BOA SAUDE");
        p.setTextAlignment(TextAlignment.CENTER);
        p.setPaddingBottom(10f);
        p.setFontSize(20f);
        
        p1 = new Paragraph("Ficha do paciente");
        p1.setPaddingBottom(10f);
        p1.setFontSize(16f);
        p1.setTextAlignment(TextAlignment.CENTER);
        
        float coluna[] = {850};
        Table tb = new Table(coluna);
        p2 = new Paragraph("Dados Pessoais");
        p2.setFontColor(new DeviceRgb(255,255,255));
        p2.setFontSize(15);
        tb.addCell(new Cell().add(p2).setPadding(3).setBorder(Border.NO_BORDER));
        tb.setBackgroundColor(new DeviceRgb(128,128,128), 20);
                 
        float sizeColuna[] = {220, 220}; //tamanho de cada coluna da tabela
        Table tabela = new Table(sizeColuna);
        tabela.addCell(new Cell().add(new Paragraph("ID do paciente:")).setBorder(Border.NO_BORDER).setPaddingLeft(50f));
        tabela.addCell(new Cell().add(new Paragraph(idp)).setBorder(Border.NO_BORDER).setPaddingLeft(50f));
        
        tabela.addCell(new Cell().add(new Paragraph("Nome:")).setBorder(Border.NO_BORDER).setPaddingLeft(50f));
        tabela.addCell(new Cell().add(new Paragraph(nP)).setBorder(Border.NO_BORDER).setPaddingLeft(50f));
        
        tabela.addCell(new Cell().add(new Paragraph("Genero:")).setBorder(Border.NO_BORDER).setPaddingLeft(50f));
        tabela.addCell(new Cell().add(new Paragraph(gp)).setBorder(Border.NO_BORDER).setPaddingLeft(50f));
        
        tabela.addCell(new Cell().add(new Paragraph("Morada:")).setBorder(Border.NO_BORDER).setPaddingLeft(50f));
        tabela.addCell(new Cell().add(new Paragraph(morp)).setBorder(Border.NO_BORDER).setPaddingLeft(50f));
        
        tabela.addCell(new Cell().add(new Paragraph("Idade:")).setBorder(Border.NO_BORDER).setPaddingLeft(50f));
        tabela.addCell(new Cell().add(new Paragraph(idadp)).setBorder(Border.NO_BORDER).setPaddingLeft(50f));
        
        tabela.addCell(new Cell().add(new Paragraph("Numero de BI:")).setBorder(Border.NO_BORDER).setPaddingLeft(50f));
        tabela.addCell(new Cell().add(new Paragraph(biP)).setBorder(Border.NO_BORDER).setPaddingLeft(50f));
        
        tabela.addCell(new Cell().add(new Paragraph("Estado Civil:")).setBorder(Border.NO_BORDER).setPaddingLeft(50f));
        tabela.addCell(new Cell().add(new Paragraph(civilp)).setBorder(Border.NO_BORDER).setPaddingLeft(50f));
        
        tabela.addCell(new Cell().add(new Paragraph("Nacionalidade:")).setBorder(Border.NO_BORDER).setPaddingLeft(50f));
        tabela.addCell(new Cell().add(new Paragraph(nacioP)).setBorder(Border.NO_BORDER).setPaddingLeft(50f));
        
        tabela.addCell(new Cell().add(new Paragraph("Telefone:")).setBorder(Border.NO_BORDER).setPaddingLeft(50f));
        tabela.addCell(new Cell().add(new Paragraph(telp)).setBorder(Border.NO_BORDER).setPaddingLeft(50f));
        
        tabela.addCell(new Cell().add(new Paragraph("Telefone Alternativo:")).setBorder(Border.NO_BORDER).setPaddingLeft(50f));
        tabela.addCell(new Cell().add(new Paragraph(telAlt)).setBorder(Border.NO_BORDER).setPaddingLeft(50f));
        
        tabela.addCell(new Cell().add(new Paragraph("Apelido:")).setBorder(Border.NO_BORDER).setPaddingLeft(50f));
        tabela.addCell(new Cell().add(new Paragraph(apelip)).setBorder(Border.NO_BORDER).setPaddingLeft(50f));
          
        
        p3 = new Paragraph("");
        p3.setPaddingTop(20f); 
        
        Table tb1 = new Table(coluna);
        p6 = new Paragraph("Dados Clinicos");
        p6.setFontColor(new DeviceRgb(255,255,255));
        p6.setFontSize(15);
        tb1.addCell(new Cell().add(p6).setPadding(3).setBorder(Border.NO_BORDER));
        tb1.setBackgroundColor(new DeviceRgb(128,128,128), 20);
        
        
        p4 = new Paragraph("Consultas Marcadas:");
        p4.setPaddingTop(5f); 
        p4.setFontSize(14);
        p4.setBold();
        float colCons[] = {200,200,200,200};
        Table tabela2 = new Table(colCons);
        
        tabela2.setMarginLeft(50f);
        tabela2.addCell(new Cell().add(new Paragraph("Nr. da Consulta").setBold().setFontSize(14).setPaddingBottom(3))
                 .setBorder(Border.NO_BORDER).setFontColor(new DeviceRgb(105,105,105)));
        tabela2.addCell(new Cell().add(new Paragraph("Data").setBold().setFontSize(14)).setBorder(Border.NO_BORDER).setFontColor(new DeviceRgb(105,105,105)));
        tabela2.addCell(new Cell().add(new Paragraph("Hora").setBold().setFontSize(14)).setBorder(Border.NO_BORDER).setFontColor(new DeviceRgb(105,105,105)));
        tabela2.addCell(new Cell().add(new Paragraph("Nome do Medico:").setBold().setFontSize(14)).setBorder(Border.NO_BORDER).setFontColor(new DeviceRgb(105,105,105)));
          
          for(int i =0; i<listCons.size();i++){
               tabela2.addCell(new Cell().add(new Paragraph(String.valueOf(listCons.get(i).getNrConsulta())))
                       .setBorder(Border.NO_BORDER));
               tabela2.addCell(new Cell().add(new Paragraph(listCons.get(i).getData())).setBorder(Border.NO_BORDER));
               tabela2.addCell(new Cell().add(new Paragraph(listCons.get(i).getHora())).setBorder(Border.NO_BORDER));
               tabela2.addCell(new Cell().add(new Paragraph(listCons.get(i).getMedico())).setBorder(Border.NO_BORDER));
          
          }
               
        p5 = new Paragraph("Cirurgias Marcadas:");
        p5.setPaddingTop(15f);
        p5.setFontSize(14);
        p5.setBold();
        float colCir[] = {200,200,200,200};
         Table tabela3 = new Table(colCir);
         
        tabela3.setMarginLeft(50f);
        tabela3.addCell(new Cell().add(new Paragraph("Nr. da Cirurgia:").setBold().setFontSize(14).setFontColor(new DeviceRgb(105,105,105)))
                 .setBorder(Border.NO_BORDER));
        tabela3.addCell(new Cell().add(new Paragraph("Data").setFontSize(14).setBold()).setBorder(Border.NO_BORDER).setFontColor(new DeviceRgb(105,105,105)));
        tabela3.addCell(new Cell().add(new Paragraph("Hora").setFontSize(14)).setBold().setBorder(Border.NO_BORDER).setFontColor(new DeviceRgb(105,105,105)));
        tabela3.addCell(new Cell().add(new Paragraph("Nome do Medico:").setBold().setFontSize(14)).setBorder(Border.NO_BORDER).setFontColor(new DeviceRgb(105,105,105)));
        //tabela3.addCell(new Cell().add(new Paragraph("Nome Enfermeiro").setFontSize(14)).setBorde)r(Border.NO_BORDER));
         
        for(int i =0; i<listCir.size();i++){
               tabela3.addCell(new Cell().add(new Paragraph(String.valueOf(listCir.get(i).getNrCirurgia())))
                       .setBorder(Border.NO_BORDER));
               tabela3.addCell(new Cell().add(new Paragraph(listCir.get(i).getData())).setBorder(Border.NO_BORDER));
               tabela3.addCell(new Cell().add(new Paragraph(listCir.get(i).getHora())).setBorder(Border.NO_BORDER));
               tabela3.addCell(new Cell().add(new Paragraph(listCir.get(i).getMedico())).setBorder(Border.NO_BORDER));
          
          }
        
        p7 = new Paragraph("");
        p7.setPaddingTop(10f);
        p7.setBorderBottom(new SolidBorder(0.3f));
        
        p8 = new Paragraph("Maputo-Mocambique\t Tel: +258 84765484");
        p8.setFontSize(10);
        p8.setFontColor(new DeviceRgb(128,128,128));
        
        doc.showTextAligned(p8, 50, 30, TextAlignment.LEFT);
        doc.add(img);
        doc.add(p);
        doc.add(p1);
        doc.add(tb);
        doc.add(new Paragraph(""));
        doc.add(tabela);
        doc.add(p3);
        doc.add(tb1);
        doc.add(p4);
        doc.add(tabela2);
        doc.add(p5);
        doc.add(tabela3);
        //doc.add(p7); doc.add(p8);
        
        doc.close();
        
        Desktop desk = null;
        if(Desktop.isDesktopSupported()){
            desk = Desktop.getDesktop();
            desk.open(new File("Relatorio do(a) paciente "+n+".pdf"));
        }
   
    }
    
    
}
