
package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class VariousInputAction extends Action {

    
    //キャンセルボタンが押されたかどうかを次画面に知らせるBeanを格納する場合のキー
    private static final String CANCEL = "isCancel";

        public ActionForward execute(ActionMapping mapping,
                ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception {
        
            //1)キャンセルボタンの判定の仕方
            if(isCancelled(request)){
                //キャンセルボタンを押されている場合は次の画面にわかるようにフラグをリクエストオブジェクトに格納する
                request.setAttribute(CANCEL,new Boolean(true));
            }
        
        return mapping.findForward("various");
    }
}
