package com.forestsoftware.kands2revamp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ADEOY3 on 10/31/2016.
 */

public class SongData {
    public static HashMap<String, List<String>> getData()
    {
        HashMap<String, List<String>> songListDetail = new HashMap<String, List<String>>();

        String[] cricketObjects = {"India","Pakistan","Australia","England","South Africa"};
        List<String> cricket =  Arrays.asList(cricketObjects);
       // List<String> cricket = new ArrayList<String>();

//        OrinAkúnlẹkọi-xlv33-5
//        cricket.add("India");
//        cricket.add("Pakistan");
//        cricket.add("Australia");
//        cricket.add("England");
//        cricket.add("South Africa");

        String[] footballObjects = {"Brazil","Spain","Germany","Netherlands","Italy"};
        List<String> football =  Arrays.asList(footballObjects);
//        List<String> football = new ArrayList<String>();
//        football.add("Brazil");
//        football.add("Spain");
//        football.add("Germany");
//        football.add("Netherlands");
//        football.add("Italy");


        String[] basketballObjects = {"United States","Spain","Argentina","France","Russia"};
        List<String> basketball =  Arrays.asList(basketballObjects);

       // String querry = "select * from database where _id "

//        List<String> basketball = new ArrayList<String>();
//        basketball.add("United States");
//        basketball.add("Spain");
//        basketball.add("Argentina");
//        basketball.add("France");
//        basketball.add("Russia");

        songListDetail.put("CRICKET TEAMS", cricket);
        songListDetail.put("FOOTBALL TEAMS", football);
        songListDetail.put("BASKETBALL TEAMS", basketball);
//
//        String [] may = {"United States","Spain","Argentina","France","Russia"};
//        List<String>june =  Arrays.asList(may);

//       for (int i=0; i< may.length; i++)
//       {
//           songListDetail.put(may[i], basketball);
//       }

        songListDetail.put("Orin Akúnlẹkọ i- xlv", basketball);
        songListDetail.put("Orin Owurọ 1 - 8", basketball);
        songListDetail.put("OrinAlẹ 9 - 19", basketball);
        songListDetail.put("Orin Ọjọ Isinmi 20 - 44", basketball);
        songListDetail.put("Orin Idariji Ẹsẹ 45 - 71", basketball);
        songListDetail.put(" Orin Iyasi Mimọ 72 - 80", basketball);
        songListDetail.put("Orin Ọpẹ 81 - 149", basketball);
        songListDetail.put("OrinIyin 150 - 152 ", basketball);
        songListDetail.put("Orin Agbara Ẹmi Mimọ 153 - 166 ", basketball);
        songListDetail.put("Orin Ikore 167 - 177 ", basketball);
        songListDetail.put("Orin Bibọ Jesu 178 - 197 ", basketball);
        songListDetail.put("Orin Ibi Kristi 198 - 209", basketball);
        songListDetail.put("Orin Opin Ọdun 210 - 213", basketball);
        songListDetail.put("Orin Opin Ọdun 210 - 213", basketball);
        songListDetail.put("Orin Ifihan 214 - 217", basketball);
        songListDetail.put("Orin Ọdun Tuntun 218 - 234", basketball);
        songListDetail.put("Orin Irònúpiwàdà (Lenti)235 - 285", basketball);
        songListDetail.put("Orin Isinmi Ọpẹ 286 - 288", basketball);
        songListDetail.put("Orin Ọsẹ Ijiya Jesu 289 - 308", basketball);
        songListDetail.put("Orin Asalẹ Ajinde 309 - 316 ", basketball);
        songListDetail.put("Orin Ajinde Jesu 317 - 340 ", basketball);
        songListDetail.put("Orin Igoke Re Ọrun341 - 349 ", basketball);
        songListDetail.put("Orin Oke Ọrun 350 - 376 ", basketball);
        songListDetail.put("Orin Pentikọsti 377 - 385 ", basketball);
        songListDetail.put("Orin Ọjọ Isinmi Funfun 386 - 387 ", basketball);
        songListDetail.put("Orin Ọjọ Mẹtalọkan 388 - 395 ", basketball);
        songListDetail.put("Orin Ọrọ Ọlọrun 396 - 408", basketball);
        songListDetail.put("Orin Adura 409 - 436", basketball);
        songListDetail.put("Orin Igbàgbọ 437 - 473", basketball);
        songListDetail.put("Orin Abo 474 - 478 ", basketball);
        songListDetail.put("Orin Anu ati Ipese 479 - 490", basketball);
        songListDetail.put("Orin Iwosàn 491 - 496", basketball);
        songListDetail.put("Orin Isẹgun497 - 512", basketball);
        songListDetail.put("Orin Ifẹ si Ọlọrun 513 – 525 TEAMS", basketball);
        songListDetail.put("Orin Ifẹ si Ọmọ Ẹnikeji 526 - 536 ", basketball);
        songListDetail.put("Orin Iwa Mimọ 537 - 549 ", basketball);
        songListDetail.put("Orin Irin Ajo ati Ijagun 550 - 582 ", basketball);
        songListDetail.put("OrinIsẹ Isin 583 - 601", basketball);
        songListDetail.put("Orin Ikilọ ati Ipe 602 - 612", basketball);
        songListDetail.put("Orin Iribọmi 613 - 623", basketball);
        songListDetail.put("Orin Imulọkanle 624 - 645 ", basketball);
        songListDetail.put("Orin Ounjẹ Ale Oluwa(Idapo Mimọ) 646 - 652", basketball);
        songListDetail.put("OrinIgbeyawo653 - 660 TEAMS", basketball);
        songListDetail.put("Orin Isọmọ L’orukọ 661 - 662 ", basketball);
        songListDetail.put("Orin Ọjọ Obi ati Ọmọde 663 - 688 ", basketball);
        songListDetail.put("Orin Ifi Ipile Lelẹ 689 - 693 ", basketball);
        songListDetail.put("Orin Isile 694 - 697 ", basketball);
        songListDetail.put("Orin Ijọ Ounjẹ ọrun loke Ọrun 698 - 700", basketball);
        songListDetail.put("Orin Ajọdun 701 - 726 ", basketball);
        songListDetail.put("Orin Ajọdun Maikeli Mimọ 727 - 730", basketball);
        songListDetail.put("Orin Kérúbù ati Séráfù 731 - 748 ", basketball);
        songListDetail.put("Orin Isinku 749 - 768 ", basketball);
        songListDetail.put("Orin Saaju Adura 769 - 773", basketball);
        songListDetail.put("Orin Saju Ore-Ọfẹ ati Ibukun 774 - 782 ", basketball);
        songListDetail.put("Orin Oniruru Igba ati Ore Ọlọrun 783 - 864 ", basketball);
        songListDetail.put("Orin Isọji ati Idaraya Emi 1 - 49", basketball);
        songListDetail.put("Orin Dafidi (Psalms 24, 32, 51, 99 100, 116, 128, 130, 133)", basketball);
        songListDetail.put("Adura Oluwa", basketball);
        songListDetail.put("Igbagbọ ", basketball);
        songListDetail.put("Asayan Ọrọ Ọlọrun ", basketball);
        songListDetail.put("Katikismu ", basketball);
        songListDetail.put("Awọn Ohun Orin", basketball);
        songListDetail.put("Itọka Awọn Ibẹrẹ Orin", basketball);
        songListDetail.put("Orin Akunlẹkọ (Afikun) ", basketball);


       // Collections.sort(songListDetail,Collections.reverseOrder());

//        songListDetail.put("BASKETBALL TEAMS", basketball);
//        songListDetail.put("BASKETBALL TEAMS", basketball);
//        songListDetail.put("BASKETBALL TEAMS", basketball);
//        songListDetail.put("BASKETBALL TEAMS", basketball);
//        songListDetail.put("BASKETBALL TEAMS", basketball);
//        songListDetail.put("BASKETBALL TEAMS", basketball);
//        songListDetail.put("BASKETBALL TEAMS", basketball);
//        songListDetail.put("BASKETBALL TEAMS", basketball);
//        songListDetail.put("BASKETBALL TEAMS", basketball);
//        songListDetail.put("BASKETBALL TEAMS", basketball);
//        songListDetail.put("BASKETBALL TEAMS", basketball);
//
//
//        songListDetail.put("BASKETBALL TEAMS", basketball);
//        songListDetail.put("BASKETBALL TEAMS", basketball);
//        songListDetail.put("BASKETBALL TEAMS", basketball);
//        songListDetail.put("BASKETBALL TEAMS", basketball);
//        songListDetail.put("BASKETBALL TEAMS", basketball);
//        songListDetail.put("BASKETBALL TEAMS", basketball);
//        songListDetail.put("BASKETBALL TEAMS", basketball);
//        songListDetail.put("BASKETBALL TEAMS", basketball);
//        songListDetail.put("BASKETBALL TEAMS", basketball);
//        songListDetail.put("BASKETBALL TEAMS", basketball);
//        songListDetail.put("BASKETBALL TEAMS", basketball);
//        songListDetail.put("BASKETBALL TEAMS", basketball);
//        songListDetail.put("BASKETBALL TEAMS", basketball);
//        songListDetail.put("BASKETBALL TEAMS", basketball);
//        songListDetail.put("BASKETBALL TEAMS", basketball);
//        songListDetail.put("BASKETBALL TEAMS", basketball);
//        songListDetail.put("BASKETBALL TEAMS", basketball);
        return songListDetail;





// 63.Orin Akunlẹkọ (Afikun)AWỌN OLORI ORI-ORIN NO. ORUKỌORINOJU EWE1.OrinAkunlẹkọi-xlv33-572.OrinOwurọ1 - 83.OrinAlẹ9 - 194.OrinỌjo Isinmi20 - 445.OrinIdariji Esẹ45 - 716.OrinIyasi Mimọ72 - 807.OrinỌpẹ81 - 1498.OrinIyin150 - 1529.OrinAgbara Ẹmi Mimọ153 - 16610.OrinIkore167 - 17711.OrinBibọ Jesu178 - 19712.OrinIbi Kristi198 - 20913.OrinOpin Ọdun210 - 21314.OrinIfihan214 - 21715.OrinỌdun Tuntun218 - 23416.OrinIrònúpiwàdà (Lenti)235 - 28517.OrinIsinmi Ọpẹ286 - 28818.OrinỌse Ijiya Jesu289 - 30819.OrinAsalẹ Ajinde309 - 31620.OrinAjinde Jesu317 - 34021.OrinIgoke Re Ọrun341 - 34922.OrinOke Ọrun350 - 37623.OrinPentikọsti377 - 38524.OrinỌjọ Isinmi Funfun386 - 38725.OrinỌjọ Mẹtalọkan388 - 39526.OrinỌrọ Ọlọrun396 - 40827.OrinAdura409 - 43628.OrinIgbagbọ437 - 47329.OrinAabo474 - 47830.OrinAnu ati Ipese479 - 49031.OrinIwosan491 - 49632.OrinIsẹgun497 - 51233.OrinIfẹ si Ọlọrun513 - 525


    }

}
