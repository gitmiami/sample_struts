
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import model.Product;

public class CatalogDAO {

    //���i�ꗗ����������SQL
    private static final String SELECT = "select * from catalog";
    
    //�w�肳�ꂽ���iID�������i����������SQL
    private static final String SELECTDETAIL ="select * from catalog where id=?";

    private DataSource source;

    public CatalogDAO(DataSource src) {
        source = src;
    }

    public Product getProduct(int id) throws SQLException{
        //���iID�ɂ��Ă͂܂�Product�N���X�̃C���X�^���X���������郁�\�b�h
        
        Connection con = source.getConnection();

        PreparedStatement pStmt = con.prepareStatement(SELECTDETAIL);
        ResultSet rs = null;
        
        try{
            pStmt.setInt(1,id);
            rs = pStmt.executeQuery();
        
            if(rs.next()){
                return getProduct(rs);
            }

        }catch(SQLException ex){
            throw ex;
        }finally{
            //���\�[�X�̌㏈��
            if(rs != null){
                rs.close();
            }
            pStmt.close();
            con.close();
        }
        
        return null;
    }

    public List<Product> getProductList() throws SQLException {
        List<Product> list = new ArrayList<Product>();
        Connection con = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;

        try {

            con = source.getConnection();

            pStmt = con.prepareStatement(SELECT);
            rs = pStmt.executeQuery();

            while (rs.next()) {
                //ResultSet����Product�N���X�̃C���X�^���X�ɕϊ����A���̃C���X�^���X��List�ɓ����
                list.add(getProduct(rs));
            }

        } catch (SQLException ex) {
            throw ex;
        } finally {
            rs.close();
            pStmt.close();
            con.close();
        }

        return list;
    }


   private Product getProduct(ResultSet rs) throws SQLException {

        //1) ResultSet����Product�N���X�ւ̕ϊ�
        Product pro = new Product();
        
        pro.setId(rs.getInt("id"));
        pro.setName(rs.getString("name"));
        pro.setPrice(rs.getInt("price"));
        pro.setDetail(rs.getString("detail"));
        pro.setPictureUrl(rs.getString("pictureurl"));
        
        return pro;
   }
}
