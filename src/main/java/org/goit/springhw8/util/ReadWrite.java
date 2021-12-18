//package org.goit.springhw8.util;
//
//import lombok.AllArgsConstructor;
//import org.goit.springhw8.model.English;
//import org.goit.springhw8.repository.EnglishRepository;
//import org.springframework.stereotype.Service;
//
//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Collections;
//import java.util.List;
//
//@Service
//@AllArgsConstructor
//public class ReadWrite {
//
//    public static EnglishRepository englishRepository;
//
//    public ReadWrite(EnglishRepository englishRepository){
//        ReadWrite.englishRepository =englishRepository;
//    }
//
//    public static List<English> readFile() {
//
//        //BufferedReader br = new BufferedReader(new FileReader("original.txt"))
//        List<English> listOfData = englishRepository.findAll();
////        int i = 0;
////        while (i < listOfData.size()) {
////            English d = listOfData.get(i);
////            while ((d.toString() != null)) {
////                listOfData.add(d);
////            }
////            i++;
////            return listOfData;
////        }
//        return listOfData;
//    }
//
//
//    public static void writeFile(List<English> listOfData) throws IOException{
//        try(BufferedWriter bw = new BufferedWriter(new FileWriter("english.txt"))){
//            for(English str: listOfData){
//                bw.write(String.valueOf(str));
//                bw.newLine();
//            }
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        List<English> data = Collections.unmodifiableList(readFile());
//        writeFile(data);
//    }
//}
