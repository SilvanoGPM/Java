package br.com.sky.javacore.l23nio.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AtributosBasicosTest {
    public static void main(String[] args) throws IOException{
        Date data = new GregorianCalendar(2015,Calendar.DECEMBER,1).getTime();
        File file = new File("folder\\arquivo_renomeado.txt");
        file.createNewFile();
        file.setLastModified(data.getTime());
        System.out.println("Ultima modificação(FILE): "+file.lastModified());
        file.delete();

        System.out.println("----------------------------------");

        Path path = Paths.get("folder\\arquivo_path.txt");
        Files.createFile(path);
        FileTime fileTime = FileTime.fromMillis(data.getTime());
        Files.setLastModifiedTime(path,fileTime);
        System.out.println("Ultima Modificação(PATH): "+Files.getLastModifiedTime(path));
        Files.deleteIfExists(path);

        System.out.println("----------------------------------");

        path = Paths.get("C:\\Users\\campeão\\IdeaProjects\\Java\\src\\br\\com\\abc\\javacore\\Aintroducaoclasses\\classes\\Carro.java");
        System.out.println("Arquivo: "+path.toAbsolutePath());
        System.out.println("IsReadble? "+Files.isReadable(path));
        System.out.println("IsExecutable? "+Files.isExecutable(path));
        System.out.println("IsWritable? "+Files.isWritable(path));

        // BasicFileAttributes: Atributos básicos de todos os SOs.
        // PosixFileAttributes: Atributos de SOs Unix.
        // DosFileAttributes: Atributos de SOs Windows.

        BasicFileAttributes atributosBasicos = Files.readAttributes(path, BasicFileAttributes.class);
        System.out.println("Data de criação: "+atributosBasicos.creationTime());
        System.out.println("Ultima vez acessado: "+atributosBasicos.lastAccessTime());
        System.out.println("Ultima vez modificado: "+atributosBasicos.lastModifiedTime());

        // BasicFileAttributesView: Modifica os atributos básicos de todos SOs.
        // PosixFileAttributesView: Modifica os atributos de SOs Unix.
        // DosFileAttributeView: Modifica os atributos de SOs Windows.
        // FileOwnerAttributeView: Seta o dono do diretorio ou arquivo.
        // AclFileAttributeView: Permissões mais avançadas para trabalhar em diretórios e arquivos.

        System.out.println("----------------------------------");

        Date last = new GregorianCalendar(2000,Calendar.AUGUST, 1).getTime();
        Date acess = new GregorianCalendar(3000,Calendar.DECEMBER, 30).getTime();
        FileTime lastModified = FileTime.fromMillis(last.getTime());
        FileTime lastAcess = FileTime.fromMillis(acess.getTime());
        FileTime creationTime = atributosBasicos.creationTime();
        BasicFileAttributeView atributosBasicosView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        atributosBasicosView.setTimes(lastModified,lastAcess,creationTime);
        atributosBasicos = Files.readAttributes(path, BasicFileAttributes.class);
        System.out.println("MODIFICADO!");
        System.out.println("Data de criação: "+atributosBasicos.creationTime());
        System.out.println("Ultima vez acessado: "+atributosBasicos.lastAccessTime());
        System.out.println("Ultima vez modificado: "+atributosBasicos.lastModifiedTime());
    }
}
