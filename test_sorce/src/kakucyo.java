import java.util.StringTokenizer;

import com.ntt.sopcs.com00.ap.Com00GetConst;
import com.ntt.sopcs.com00.ap.Com00GetMessage;
import com.ntt.sopcs.com00.ap.Com00SopcsBasis;
import com.ntt.sopcs.com00.ap.Com00SopcsException;




public class kakucyo {


    public static String[] getSimpleFormATFileExtentionStr(String upLoadFileName, boolean isError) throws Com00SopcsException {
        // ファイル名の拡張子を抜き出す
        StringTokenizer strToken = new StringTokenizer(upLoadFileName, STR_PELIOD);
        String extention_wk = "";
        String extention = "";
        int strCount = strToken.countTokens();
        for ( int i = 0 ; i < strCount; i++) {
            extention_wk = strToken.nextToken();
        }
        extention = extention_wk.toLowerCase();
        // プロパティファイルより拡張子情報取得
        String sExtention = (String)Com00SopcsBasis.getInstance().extentionList.get(simpleATkey);
        if (sExtention == null) {
            // ログ出力
            String errMsg = Com00GetMessage.getMessage(Com00GetMessage.MSE0030,simpleATkey);
            log.logOutput(ApplicationBusinessLog.LOG_LVL_ERROR, CLASSNAME + "：" + METHODNAME, errMsg);
            throw new Com00SopcsException(errMsg);
        } else {
            // ターゲットとなる拡張子情報を抜出し、結果を返す
            StringTokenizer strToken2 = new StringTokenizer(sExtention, STR_KORON);
            String extention_wk2 = "";
            int strCount2 = strToken2.countTokens();
            boolean extFlg = false;
            for(int j= 0; j < strCount2; j++) {

                extention_wk2 = strToken2.nextToken();
                if (extention_wk2.startsWith(extention)) {
                    extFlg = true;
                    break;
                }
            }
            if (extention_wk2.equals("") || !extFlg) {
                // ログ出力
                String errMsg = Com00GetMessage.getMessage(Com00GetMessage.MSE0380,"拡張子情報");
                log.logOutput(ApplicationBusinessLog.LOG_LVL_FATAL, CLASSNAME + "：" + METHODNAME,
                Com00GetMessage.getMessage(Com00GetMessage.MSE0342, extention));
// 2007/06/03 Urashima ADD 拡張子未存在の場合、バイナリとして扱うように修正 START
                if (!isError) {
                    String[] extention_wk3 = new String[Com00GetConst.getConstInt(Com00GetConst.SIMPLE_FROM_AT_FILE_EXTENTION_CNT)];
                    extention_wk3[0] = extention;
                    extention_wk3[1] = "";
                    extention_wk3[2] = EXT_BIN;
                    return extention_wk3;
                } else {
                    return null;
                }
// 2007/06/03 Urashima ADD 拡張子未存在の場合、バイナリとして扱うように修正 END
            } else {

                // 取得した結果を配列へ格納
                StringTokenizer strToken3 = new StringTokenizer(extention_wk2, STR_KANMA);
                String[] extention_wk3 = new String[Com00GetConst.getConstInt(Com00GetConst.SIMPLE_FROM_AT_FILE_EXTENTION_CNT)];
                int strCount3 = strToken3.countTokens();
                for(int k= 0; k < strCount3; k++) {
                    extention_wk3[k] = strToken3.nextToken();
                }
                return extention_wk3;
            }
        }
    }
}



