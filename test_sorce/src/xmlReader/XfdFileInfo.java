package xmlReader; 

import java.io.Serializable;

public class XfdFileInfo implements Serializable {
    
    public static final String UKETSUKE_ID_TAG = "uketsuke_id";
    
    public static final String ORDER_NO_TAG = "order_no";
    
    public static final String KEI_NAME_TAG = "kei_name";
    
    public static final String KAITSUU_DATE_TAG = "kaitsuu_date";
    
    public static final String TAIOU_NAME_TAG = "taiou_name";
    
    public static final String TAIOU_TEL_TAG = "taiou_tel";
    
    public static final String TAIOU_MAIL_TAG = "taiou_mail";

    /** ��tID */
    public String uketsukeId;

    /** �I�[�_�o�^�ԍ� */
    public String orderNo;

    /** ���q�ԍ� */
    public String keiName;

    /** �J��/�ύX/�p�~��]�� */
    public String kaitsuuDate;

    /** ���q�l�Ή�����S���� */
    public String taiouName;

    /** ���q�l�Ή�����TEL */
    public String taiouTel;

    /** ���q�l�Ή�����e-mail */
    public String taiouMain;

    /** �T�[�r�XID */
    public String service;

}
