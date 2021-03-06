package com.supply.demo;/**
 * 作者: TestSymbol-ljh
 * 创建时间: 2018/12/20 11:38
 * 声明:
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.supply.springboot.entity.Symbol;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *@ClassName TestSymbol
 *@Author Junlunet-ljh
 *@Date 2018/12/20 11:38
 *@Version 1.0
 **/
public class TestSymbol {
    @Test
    public void intoSymbol(){
        List<Symbol> symbolList = new ArrayList<>();
        String ss = "[\"btcusd\",\"ltcusd\",\"ltcbtc\",\"ethusd\",\"ethbtc\",\"etcbtc\",\"etcusd\",\"rrtusd\",\"rrtbtc\",\"zecusd\",\"zecbtc\",\"xmrusd\",\"xmrbtc\",\"dshusd\",\"dshbtc\",\"btceur\",\"btcjpy\",\"xrpusd\",\"xrpbtc\",\"iotusd\",\"iotbtc\",\"ioteth\",\"eosusd\",\"eosbtc\",\"eoseth\",\"sanusd\",\"sanbtc\",\"saneth\",\"omgusd\",\"omgbtc\",\"omgeth\",\"neousd\",\"neobtc\",\"neoeth\",\"etpusd\",\"etpbtc\",\"etpeth\",\"qtmusd\",\"qtmbtc\",\"qtmeth\",\"avtusd\",\"avtbtc\",\"avteth\",\"edousd\",\"edobtc\",\"edoeth\",\"btgusd\",\"btgbtc\",\"datusd\",\"datbtc\",\"dateth\",\"qshusd\",\"qshbtc\",\"qsheth\",\"yywusd\",\"yywbtc\",\"yyweth\",\"gntusd\",\"gntbtc\",\"gnteth\",\"sntusd\",\"sntbtc\",\"snteth\",\"ioteur\",\"batusd\",\"batbtc\",\"bateth\",\"mnausd\",\"mnabtc\",\"mnaeth\",\"funusd\",\"funbtc\",\"funeth\",\"zrxusd\",\"zrxbtc\",\"zrxeth\",\"tnbusd\",\"tnbbtc\",\"tnbeth\",\"spkusd\",\"spkbtc\",\"spketh\",\"trxusd\",\"trxbtc\",\"trxeth\",\"rcnusd\",\"rcnbtc\",\"rcneth\",\"rlcusd\",\"rlcbtc\",\"rlceth\",\"aidusd\",\"aidbtc\",\"aideth\",\"sngusd\",\"sngbtc\",\"sngeth\",\"repusd\",\"repbtc\",\"repeth\",\"elfusd\",\"elfbtc\",\"elfeth\",\"btcgbp\",\"etheur\",\"ethjpy\",\"ethgbp\",\"neoeur\",\"neojpy\",\"neogbp\",\"eoseur\",\"eosjpy\",\"eosgbp\",\"iotjpy\",\"iotgbp\",\"iosusd\",\"iosbtc\",\"ioseth\",\"aiousd\",\"aiobtc\",\"aioeth\",\"requsd\",\"reqbtc\",\"reqeth\",\"rdnusd\",\"rdnbtc\",\"rdneth\",\"lrcusd\",\"lrcbtc\",\"lrceth\",\"waxusd\",\"waxbtc\",\"waxeth\",\"daiusd\",\"daibtc\",\"daieth\",\"cfiusd\",\"cfibtc\",\"cfieth\",\"agiusd\",\"agibtc\",\"agieth\",\"bftusd\",\"bftbtc\",\"bfteth\",\"mtnusd\",\"mtnbtc\",\"mtneth\",\"odeusd\",\"odebtc\",\"odeeth\",\"antusd\",\"antbtc\",\"anteth\",\"dthusd\",\"dthbtc\",\"dtheth\",\"mitusd\",\"mitbtc\",\"miteth\",\"stjusd\",\"stjbtc\",\"stjeth\",\"xlmusd\",\"xlmeur\",\"xlmjpy\",\"xlmgbp\",\"xlmbtc\",\"xlmeth\",\"xvgusd\",\"xvgeur\",\"xvgjpy\",\"xvggbp\",\"xvgbtc\",\"xvgeth\",\"bciusd\",\"bcibtc\",\"mkrusd\",\"mkrbtc\",\"mkreth\",\"kncusd\",\"kncbtc\",\"knceth\",\"poausd\",\"poabtc\",\"poaeth\",\"lymusd\",\"lymbtc\",\"lymeth\",\"utkusd\",\"utkbtc\",\"utketh\",\"veeusd\",\"veebtc\",\"veeeth\",\"dadusd\",\"dadbtc\",\"dadeth\",\"orsusd\",\"orsbtc\",\"orseth\",\"aucusd\",\"aucbtc\",\"auceth\",\"poyusd\",\"poybtc\",\"poyeth\",\"fsnusd\",\"fsnbtc\",\"fsneth\",\"cbtusd\",\"cbtbtc\",\"cbteth\",\"zcnusd\",\"zcnbtc\",\"zcneth\",\"senusd\",\"senbtc\",\"seneth\",\"ncausd\",\"ncabtc\",\"ncaeth\",\"cndusd\",\"cndbtc\",\"cndeth\",\"ctxusd\",\"ctxbtc\",\"ctxeth\",\"paiusd\",\"paibtc\",\"seeusd\",\"seebtc\",\"seeeth\",\"essusd\",\"essbtc\",\"esseth\",\"atmusd\",\"atmbtc\",\"atmeth\",\"hotusd\",\"hotbtc\",\"hoteth\",\"dtausd\",\"dtabtc\",\"dtaeth\",\"iqxusd\",\"iqxbtc\",\"iqxeos\",\"wprusd\",\"wprbtc\",\"wpreth\",\"zilusd\",\"zilbtc\",\"zileth\",\"bntusd\",\"bntbtc\",\"bnteth\",\"absusd\",\"abseth\",\"xrausd\",\"xraeth\",\"manusd\",\"maneth\",\"bbnusd\",\"bbneth\",\"niousd\",\"nioeth\",\"dgxusd\",\"dgxeth\",\"vetusd\",\"vetbtc\",\"veteth\",\"utnusd\",\"utneth\",\"tknusd\",\"tkneth\",\"gotusd\",\"goteur\",\"goteth\",\"xtzusd\",\"xtzbtc\",\"cnnusd\",\"cnneth\",\"boxusd\",\"boxeth\",\"trxeur\",\"trxgbp\",\"trxjpy\",\"mgousd\",\"mgoeth\",\"rteusd\",\"rteeth\",\"yggusd\",\"yggeth\",\"mlnusd\",\"mlneth\",\"wtcusd\",\"wtceth\",\"csxusd\",\"csxeth\",\"omnusd\",\"omnbtc\",\"intusd\",\"inteth\",\"drnusd\",\"drneth\",\"pnkusd\",\"pnketh\",\"dgbusd\",\"dgbbtc\",\"bsvusd\",\"bsvbtc\",\"babusd\",\"babbtc\",\"wlousd\",\"wloxlm\",\"vldusd\",\"vldeth\",\"enjusd\",\"enjeth\",\"onlusd\",\"onleth\",\"rbtusd\",\"rbtbtc\",\"ustusd\",\"euteur\",\"eutusd\",\"gsdusd\",\"udcusd\",\"tsdusd\",\"paxusd\"]";
        JSONArray sjo = JSON.parseArray(ss);
        for (int i=0;i<sjo.size();i++){
            String symbol = sjo.get(i).toString();
            String newsymbol = symbol.substring(0,3) + "/" +symbol.substring(3);
            symbolList.add(new Symbol("f0730724ee9c0f3ca4f85804add11d5a",newsymbol.toUpperCase(),
                    symbol.substring(3).toUpperCase(),"0"));
        }
        System.out.println(symbolList);
    }

    @Test
    public void testJson(){
        String ss = "[\"btcusd\",\"ltcusd\",\"ltcbtc\",\"ethusd\",\"ethbtc\"]";
        JSONArray symbol = JSON.parseArray(ss);
        JSONObject jo = new JSONObject();
        jo.put("market","USD");
        jo.put("symbol",symbol);
        

    }
}
