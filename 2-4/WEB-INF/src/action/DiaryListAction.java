
package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.DiaryLogic;
import model.Diary;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class DiaryListAction extends Action {
    public ActionForward execute(ActionMapping mapping,ActionForm form,HttpServletRequest req,HttpServletResponse res) throws Exception {
        
        DiaryLogic logic = new DiaryLogic(getDataSource(req));
        List<Diary> list =  logic.getDiaryContents();
        req.setAttribute("diary",list);
        
        return mapping.findForward("success");
    }

}
