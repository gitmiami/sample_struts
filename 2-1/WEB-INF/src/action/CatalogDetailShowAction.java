
package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import dao.ProductDAOUtil;

public class CatalogDetailShowAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        ProductDAOUtil util = new ProductDAOUtil();

        //1)�Z�b�V������񂩂�id�Ŏw�肳�ꂽProduct�����o��
        Product pro = util.getProductById(form, request.getSession());

        if (pro == null) {
            //2)CatalogDAO�𗘗p����Product�����o��
            pro = util.getProductById(form, getDataSource(request));
        }
        request.setAttribute("product", pro);

        return mapping.findForward("show");
    }
}