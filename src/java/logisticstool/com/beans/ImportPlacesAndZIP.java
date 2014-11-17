package logisticstool.com.beans;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Matze
 */
@ManagedBean
@SessionScoped
public class ImportPlacesAndZIP
{

    public ImportPlacesAndZIP()
    {

    }

    public List<String> getPlacesAndZIPs()
    {
        List<String> importedPlaces = new ArrayList<String>();
        importedPlaces.add("Ort:" + "   " + "PLZ:");
        
        //String csvFile = "C:\\Users\\Matze\\Documents\\NetBeansProjects\\Logistics-Tool\\zip data\\postleitzahlen_v10.xls";
        String csvFile = "C:\\Users\\Matze\\Documents\\NetBeansProjects\\Logistics-Tool\\zip data\\plz.csv";
        //String csvFile = "Users/Matze/Documents/NetBeansProjects/Logistics-Tool/zip data/plz.csv";
        BufferedReader bufferedReader = null;
        String line = "";
        String csvSplitBy = ";";
        
        //String output = "";

        try
        {
            bufferedReader = new BufferedReader(new FileReader(csvFile));
            while ((line = bufferedReader.readLine()) != null)
            {
                String[] currentLine = line.split(csvSplitBy);

                //output += "PLZ: " + currentLine[0] + "\n" +
                          //"Ort: " + currentLine[1] + "\n";
                
                importedPlaces.add(currentLine[1] + "   " + currentLine[0]);
            }
        }
        catch (FileNotFoundException fileNotFoundexception)
        {
            fileNotFoundexception.printStackTrace();
        }
        catch (IOException ioException)
        {
            ioException.printStackTrace();
        }
        finally
        {
            if (bufferedReader != null)
            {
                try
                {
                    bufferedReader.close();
                }
                catch (IOException ioException)
                {
                    ioException.printStackTrace();
                }
            }
        }
        
        //return output;
        return importedPlaces;
    }
}
