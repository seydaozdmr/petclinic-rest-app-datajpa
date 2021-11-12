package com.petclinic.rest.logging;

import com.petclinic.rest.service.CrudService;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.nio.file.Files.*;

public class MyLoggingImpl implements MyLogging {

    private static Path locPath= FileSystems.getDefault().getPath("logs.txt");
    @Override
    public void log() {
        try(BufferedWriter locFile= newBufferedWriter(locPath); BufferedWriter dirFile= newBufferedWriter(locPath)){

              locFile.write(LocalDateTime.now()+" crud işlemi gerçekleştirildi");

          } catch(IOException e){
            System.out.println("dosyaya yazılamıyor. "+e.getMessage());
        }
    }
}
