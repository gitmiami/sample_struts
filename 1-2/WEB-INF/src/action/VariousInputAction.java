
package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class VariousInputAction extends Action {

    
    //�L�����Z���{�^���������ꂽ���ǂ���������ʂɒm�点��Bean���i�[����ꍇ�̃L�[
    private static final String CANCEL = "isCancel";

        public ActionForward execute(ActionMapping mapping,
                ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception {
        
            //1)�L�����Z���{�^���̔���̎d��
            if(isCancelled(request)){
                //�L�����Z���{�^����������Ă���ꍇ�͎��̉�ʂɂ킩��悤�Ƀt���O�����N�G�X�g�I�u�W�F�N�g�Ɋi�[����
                request.setAttribute(CANCEL,new Boolean(true));
            }
        
        return mapping.findForward("various");
    }
}