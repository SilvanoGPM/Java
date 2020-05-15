package br.com.sky.javacore.l23nio.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipandoTest {
    public static void main(String[] args) {
        Path dirZip = Paths.get("pasta/subpasta");
        Path dirFiles = Paths.get("pasta/subpasta/subsubpasta");
        Path zipFiles = dirZip.resolve("arquivo.zip");

        try (ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(zipFiles.toFile()));
             DirectoryStream<Path> stream = Files.newDirectoryStream(dirFiles)) {

            for (Path path : stream) {
                ZipEntry zipEntry = new ZipEntry(path.getFileName().toString());
                zip.putNextEntry(zipEntry);
                FileInputStream fileInputStream = new FileInputStream(path.toFile());
                byte[] buff = new byte[2048];
                int bytesLidos;
                while ((bytesLidos = fileInputStream.read(buff)) > 0) {
                    zip.write(buff, 0, bytesLidos);
                }
                zip.flush();
                zip.closeEntry();
                fileInputStream.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
