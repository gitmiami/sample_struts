
package action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.DiaryLogic;
import model.Diary;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.upload.FormFile;


import util.UploadFileUtil;

public class DiaryEntryAction extends Action {
    
    public ActionForward execute(ActionMapping mapping,ActionForm form,HttpServletRequest req,HttpServletResponse res) throws Exception {
        DynaActionForm dForm = (DynaActionForm)form;
        
        //1)Uploadしたイメージファイルを決められた場所に書き出すためにファイル情報、ストリーム情報を管理します。
        FormFile fForm = (FormFile) dForm.get("imgFile");
        
        //2)日付の変換（2-2と同様）
        String date = (String)dForm.get("date");
        Date entryDate = null;
        
        //Formatの定義
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern( "yyyy-MM-dd" );
        try {
            entryDate = sdf.parse(date);
        } catch (ParseException e) {
            
            //3)日付の形式が違う場合の処理
            ActionMessages errs = new ActionMessages();
            ActionMessage err = new ActionMessage("errors.dateformat");
            errs.add("date",err);
            
            saveErrors(req,errs);
            
            return mapping.findForward("datefail");
        }
        
        //4)アップロードファイルを処理するユーティリティクラスを準備
        UploadFileUtil util = new UploadFileUtil(getServlet().getServletContext());
        
        //5)登録ロジックをDiaryEntryLogicクラスに委譲
        DiaryLogic logic = new DiaryLogic(getDataSource(req));
        logic.entry(entryDate,(String)dForm.get("content"),fForm,util);
        
        //6)日記を表示するための情報を取得するためのロジックを実行
        List<Diary> list = logic.getDiaryContents();        
        req.setAttribute("diary",list);
        
        return mapping.findForward("success");
    }
}
