package dao;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import model.Product;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.DynaActionForm;

public class ProductDAOUtil {

    public Product getProductById(ActionForm form, DataSource source)
        throws SQLException, Exception {
        int id = getIDFromForm(form);
        
        //DAO����Product�N���X�̃C���X�^���X���擾����
        CatalogDAO dao = new CatalogDAO(source);
        
        Product pro = dao.getProduct(id);
        return pro;
    }
   
    @SuppressWarnings("unchecked")
    public Product getProductById(ActionForm form,HttpSession session){
        
        int id = getIDFromForm(form);
        
        //�Z�b�V�����I�u�W�F�N�g����Product�N���X�̃C���X�^���X���擾����
        List<Product> list = (List)session.getAttribute("products");
        if(list == null){
            return null;
        }

        return getProduct(list,id);
    }

    private int getIDFromForm(ActionForm form) {
        DynaActionForm dForm = (DynaActionForm)form;
        int id = ((Integer)dForm.get("id")).intValue();
        return id;
    }
    
    private Product getProduct(List<Product> list,int id){
        for(int i=0;i<list.size();i++){
            //���i�ꗗ���������o����ID���r����
            Product pro = list.get(i);
            if(pro.getId() == id){
                return pro;
            }
        }
        return null;
    }
}