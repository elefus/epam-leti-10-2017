package com.epam.jf.common.classwork.lesson17;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;

public class TryWithResources {

    public static void main(String[] args) throws IOException {
        oldStyle();
        try {
            java7Style();
        } catch (FileNotFoundException ex) {

        }
    }

    /**
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    private static void java7Style() throws IOException {
        try (FileReader reader = new ThrowableFileReader()) {
            System.out.println(reader.read());
        } catch (IOException e) {
//            e.printStackTrace();
            throw e;
        }
    }

    public static void remoteMethod() throws RemoteException{
        try{
            throw new RemoteException("this is RemoteException");
        }
        catch(Exception e){
            throw e;
        }
    }


    private static void oldStyle() throws IOException {
        FileReader fileReader = null;
        Throwable cause = null;
        try {
            fileReader = new ThrowableFileReader();
            System.out.println(fileReader.read()); // throw IOException
        } catch (IOException ex) {
            cause = ex;
            throw ex;
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close(); // throw IOException
                }
            } catch (IOException ex) {
                if (cause != null) {
                    throw new IOException(cause.getMessage(), ex);
                }
                throw ex;
            }
        }
    }

    private static class ThrowableFileReader extends FileReader {
        public ThrowableFileReader() throws FileNotFoundException {
            super("123.txt");
        }

        @Override
        public int read() throws IOException {
            throw new IOException("From read");
        }

        @Override
        public void close() throws IOException {
            throw new IOException("From close");
        }
    }
}
