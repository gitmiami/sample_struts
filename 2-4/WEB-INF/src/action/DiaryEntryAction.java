
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
        
        //1)Upload�����C���[�W�t�@�C�������߂�ꂽ�ꏊ�ɏ����o�����߂Ƀt�@�C�����A�X�g���[�������Ǘ����܂��B
        FormFile fForm = (FormFile) dForm.get("imgFile");
        
        //2)���t�̕ϊ��i2-2�Ɠ��l�j
        String date = (String)dForm.get("date");
        Date entryDate = null;
        
        //Format�̒�`
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern( "yyyy-MM-dd" );
        try {
            entryDate = sdf.parse(date);
        } catch (ParseException e) {
            
            //3)���t�̌`�����Ⴄ�ꍇ�̏���
            ActionMessages errs = new ActionMessages();
            ActionMessage err = new ActionMessage("errors.dateformat");
            errs.add("date",err);
            
            saveErrors(req,errs);
            
            return mapping.findForward("datefail");
        }
        
        //4)�A�b�v���[�h�t�@�C�����������郆�[�e�B���e�B�N���X������
        UploadFileUtil util = new UploadFileUtil(getServlet().getServletContext());
        
        //5)�o�^���W�b�N��DiaryEntryLogic�N���X�ɈϏ�
        DiaryLogic logic = new DiaryLogic(getDataSource(req));
        logic.entry(entryDate,(String)dForm.get("content"),fForm,util);
        
        //6)���L��\�����邽�߂̏����擾���邽�߂̃��W�b�N�����s
        List<Diary> list = logic.getDiaryContents();        
        req.setAttribute("diary",list);
        
        return mapping.findForward("success");
    }
}
