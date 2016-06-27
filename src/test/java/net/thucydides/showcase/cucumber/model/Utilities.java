package net.thucydides.showcase.cucumber.model;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Ady on 24/11/15.
 */
public class Utilities {

    public static String getTimeStamp() {
        String DATE_FORMAT_NOW = "EEE, d MMM yyyy HH:mm:ss";
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        return sdf.format(cal.getTime());
    }


    public void copyResultsFolder() throws IOException {

        String result_FolderName = "Reports" + "_" + getTimeStamp();
        new File("target\\" + "\\TestReports" + result_FolderName).mkdirs();
        File source = new File(System.getProperty("user.dir") + "\\target\\" + "\\site");
        File destination = new File(System.getProperty("user.dir") + "\\target\\" + "\\TestReports\\" + result_FolderName + "\\");
        FileUtils.copyDirectory(source, destination);
    }
}
