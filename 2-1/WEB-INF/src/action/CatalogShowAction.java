package action;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import dao.CatalogDAO;
import model.Product;

public class CatalogShowAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {


    	   String encodingName = "MS932";

          request.setCharacterEncoding(encodingName);


        //struts-config.xml�ɐݒ肵���f�[�^�\�[�X�̎擾
        CatalogDAO dao = new CatalogDAO(getDataSource(request));

        try {
            //1) �f�[�^�x�[�X�̌�����DAO�ɈϏ����Ă���
            List<Product> list = dao.getProductList();


            System.out.print("detail  list�̒��g  " + list.get(0).getDetail());


            //2) �Z�b�V������Product�I�u�W�F�N�g�̃��X�g���i�[���Ă���
            request.getSession().setAttribute("products", list);

            //3)�\���̈�̐ݒ�
            request.setAttribute("offset","0");

            //4)��O�����̎d��
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return mapping.findForward("show");
    }

}