package com.hib.moudle;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * ImportStock entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "import_stock", catalog = "gopiao")
public class ImportStock extends AbstractImportStock implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public ImportStock() {
	}

	/** minimal constructor */
	public ImportStock(String id, String ��������, String ����, String ����) {
		super(id, ��������, ����, ����);
	}

	/** full constructor */
	public ImportStock(String id, String ��������, String ����, String ����,
			String �Ƿ���, String �ּ�, String �ǵ�, String �����, String ������,
			String ����, String ����, String ������, String ������, String ��, String ����,
			String ���, String ���, String ��ӯdong, String �ܽ��, String �����,
			String ��ͨ�ɱ�, String ������ҵ, String ����, String ����, String ί����,
			String ����, String ����, String �����, String ί����, String ����һ,
			String ����һ, String ���һ, String ����һ, String ���۶�, String ������,
			String ��۶�, String ������, String �����, String ������, String ������,
			String ������, String ��ͨ��ֵ, String ab������ֵ, String ���ƽ��, String ��ͷ����,
			String ��ͷֹ��, String ��ͷ�ز�, String ��ͷֹ��, String ǿ������, String ��Ծ��,
			String ÿ�ʾ���, String ÿ�ʻ���, String ��������, String ��������, String �ܹɱ�wan,
			String ���ҹ�, String ����ͬ��, String ����ͬ��, String b�ɻ�a, String h��,
			String ְ����, String ���ʲ�wan, String �����ʲ�, String �̶��ʲ�, String �����ʲ�,
			String ����Ͷ��, String ������ծ, String ���ڸ�ծ, String ������, String ÿ�ɹ���,
			String ���ʲ�, String ��Ӫ����, String ��Ӫ����, String �о���, String Ӫҵ����,
			String Ͷ������, String ��Ӫ�ֽ���, String ���ֽ���, String ���, String �����ܶ�,
			String ˰������, String ������, String δ������, String ÿ�ɾ���, String ��������,
			String ������, String ÿ��δ����, String ÿ������, String Ȩ�����) {
		super(id, ��������, ����, ����, �Ƿ���, �ּ�, �ǵ�, �����, ������, ����, ����, ������, ������, ��,
				����, ���, ���, ��ӯdong, �ܽ��, �����, ��ͨ�ɱ�, ������ҵ, ����, ����, ί����, ����, ����,
				�����, ί����, ����һ, ����һ, ���һ, ����һ, ���۶�, ������, ��۶�, ������, �����, ������,
				������, ������, ��ͨ��ֵ, ab������ֵ, ���ƽ��, ��ͷ����, ��ͷֹ��, ��ͷ�ز�, ��ͷֹ��, ǿ������,
				��Ծ��, ÿ�ʾ���, ÿ�ʻ���, ��������, ��������, �ܹɱ�wan, ���ҹ�, ����ͬ��, ����ͬ��, b�ɻ�a, h��,
				ְ����, ���ʲ�wan, �����ʲ�, �̶��ʲ�, �����ʲ�, ����Ͷ��, ������ծ, ���ڸ�ծ, ������, ÿ�ɹ���,
				���ʲ�, ��Ӫ����, ��Ӫ����, �о���, Ӫҵ����, Ͷ������, ��Ӫ�ֽ���, ���ֽ���, ���, �����ܶ�, ˰������,
				������, δ������, ÿ�ɾ���, ��������, ������, ÿ��δ����, ÿ������, Ȩ�����);
	}

}
