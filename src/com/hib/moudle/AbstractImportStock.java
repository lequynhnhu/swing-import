package com.hib.moudle;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * AbstractImportStock entity provides the base persistence definition of the
 * ImportStock entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractImportStock implements java.io.Serializable {

	// Fields

	private String id;
	private String ��������;
	private String ����;
	private String ����;
	private String �Ƿ���;
	private String �ּ�;
	private String �ǵ�;
	private String �����;
	private String ������;
	private String ����;
	private String ����;
	private String ������;
	private String ������;
	private String ��;
	private String ����;
	private String ���;
	private String ���;
	private String ��ӯdong;
	private String �ܽ��;
	private String �����;
	private String ��ͨ�ɱ�;
	private String ������ҵ;
	private String ����;
	private String ����;
	private String ί����;
	private String ����;
	private String ����;
	private String �����;
	private String ί����;
	private String ����һ;
	private String ����һ;
	private String ���һ;
	private String ����һ;
	private String ���۶�;
	private String ������;
	private String ��۶�;
	private String ������;
	private String �����;
	private String ������;
	private String ������;
	private String ������;
	private String ��ͨ��ֵ;
	private String ab������ֵ;
	private String ���ƽ��;
	private String ��ͷ����;
	private String ��ͷֹ��;
	private String ��ͷ�ز�;
	private String ��ͷֹ��;
	private String ǿ������;
	private String ��Ծ��;
	private String ÿ�ʾ���;
	private String ÿ�ʻ���;
	private String ��������;
	private String ��������;
	private String �ܹɱ�wan;
	private String ���ҹ�;
	private String ����ͬ��;
	private String ����ͬ��;
	private String b�ɻ�a;
	private String h��;
	private String ְ����;
	private String ���ʲ�wan;
	private String �����ʲ�;
	private String �̶��ʲ�;
	private String �����ʲ�;
	private String ����Ͷ��;
	private String ������ծ;
	private String ���ڸ�ծ;
	private String ������;
	private String ÿ�ɹ���;
	private String ���ʲ�;
	private String ��Ӫ����;
	private String ��Ӫ����;
	private String �о���;
	private String Ӫҵ����;
	private String Ͷ������;
	private String ��Ӫ�ֽ���;
	private String ���ֽ���;
	private String ���;
	private String �����ܶ�;
	private String ˰������;
	private String ������;
	private String δ������;
	private String ÿ�ɾ���;
	private String ��������;
	private String ������;
	private String ÿ��δ����;
	private String ÿ������;
	private String Ȩ�����;
	private String ����;
	private String ����;
	private String �ɽ���;
	private String �ɽ���;

	// Constructors

	/** default constructor */
	public AbstractImportStock() {
	}

	/** minimal constructor */
	public AbstractImportStock(String id, String ��������, String ����, String ����) {
		this.id = id;
		this.�������� = ��������;
		this.���� = ����;
		this.���� = ����;
	}

	/** full constructor */
	public AbstractImportStock(String id, String ��������, String ����, String ����,
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
		this.id = id;
		this.�������� = ��������;
		this.���� = ����;
		this.���� = ����;
		this.�Ƿ��� = �Ƿ���;
		this.�ּ� = �ּ�;
		this.�ǵ� = �ǵ�;
		this.����� = �����;
		this.������ = ������;
		this.���� = ����;
		this.���� = ����;
		this.������ = ������;
		this.������ = ������;
		this.�� = ��;
		this.���� = ����;
		this.��� = ���;
		this.��� = ���;
		this.��ӯdong = ��ӯdong;
		this.�ܽ�� = �ܽ��;
		this.����� = �����;
		this.��ͨ�ɱ� = ��ͨ�ɱ�;
		this.������ҵ = ������ҵ;
		this.���� = ����;
		this.���� = ����;
		this.ί���� = ί����;
		this.���� = ����;
		this.���� = ����;
		this.����� = �����;
		this.ί���� = ί����;
		this.����һ = ����һ;
		this.����һ = ����һ;
		this.���һ = ���һ;
		this.����һ = ����һ;
		this.���۶� = ���۶�;
		this.������ = ������;
		this.��۶� = ��۶�;
		this.������ = ������;
		this.����� = �����;
		this.������ = ������;
		this.������ = ������;
		this.������ = ������;
		this.��ͨ��ֵ = ��ͨ��ֵ;
		this.ab������ֵ = ab������ֵ;
		this.���ƽ�� = ���ƽ��;
		this.��ͷ���� = ��ͷ����;
		this.��ͷֹ�� = ��ͷֹ��;
		this.��ͷ�ز� = ��ͷ�ز�;
		this.��ͷֹ�� = ��ͷֹ��;
		this.ǿ������ = ǿ������;
		this.��Ծ�� = ��Ծ��;
		this.ÿ�ʾ��� = ÿ�ʾ���;
		this.ÿ�ʻ��� = ÿ�ʻ���;
		this.�������� = ��������;
		this.�������� = ��������;
		this.�ܹɱ�wan = �ܹɱ�wan;
		this.���ҹ� = ���ҹ�;
		this.����ͬ�� = ����ͬ��;
		this.����ͬ�� = ����ͬ��;
		this.b�ɻ�a = b�ɻ�a;
		this.h�� = h��;
		this.ְ���� = ְ����;
		this.���ʲ�wan = ���ʲ�wan;
		this.�����ʲ� = �����ʲ�;
		this.�̶��ʲ� = �̶��ʲ�;
		this.�����ʲ� = �����ʲ�;
		this.����Ͷ�� = ����Ͷ��;
		this.������ծ = ������ծ;
		this.���ڸ�ծ = ���ڸ�ծ;
		this.������ = ������;
		this.ÿ�ɹ��� = ÿ�ɹ���;
		this.���ʲ� = ���ʲ�;
		this.��Ӫ���� = ��Ӫ����;
		this.��Ӫ���� = ��Ӫ����;
		this.�о��� = �о���;
		this.Ӫҵ���� = Ӫҵ����;
		this.Ͷ������ = Ͷ������;
		this.��Ӫ�ֽ��� = ��Ӫ�ֽ���;
		this.���ֽ��� = ���ֽ���;
		this.��� = ���;
		this.�����ܶ� = �����ܶ�;
		this.˰������ = ˰������;
		this.������ = ������;
		this.δ������ = δ������;
		this.ÿ�ɾ��� = ÿ�ɾ���;
		this.�������� = ��������;
		this.������ = ������;
		this.ÿ��δ���� = ÿ��δ����;
		this.ÿ������ = ÿ������;
		this.Ȩ����� = Ȩ�����;
	}

	// Property accessors
	@Id
	@Column(name = "ID", nullable = false, length = 36)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "��������", nullable = false, length = 19)
	public String get��������() {
		return this.��������;
	}

	public void set��������(String ��������) {
		this.�������� = ��������;
	}

	@Column(name = "����" , length = 10)
	public String get����() {
		return this.����;
	}

	public void set����(String ����) {
		this.���� = ����;
	}

	@Column(name = "����", nullable = false, length = 30)
	public String get����() {
		return this.����;
	}

	public void set����(String ����) {
		this.���� = ����;
	}

	@Column(name = "�Ƿ���", length = 8)
	public String get�Ƿ���() {
		return this.�Ƿ���;
	}

	public void set�Ƿ���(String �Ƿ���) {
		this.�Ƿ��� = �Ƿ���;
	}

	@Column(name = "�ּ�", length = 8)
	public String get�ּ�() {
		return this.�ּ�;
	}

	public void set�ּ�(String �ּ�) {
		this.�ּ� = �ּ�;
	}

	@Column(name = "�ǵ�", length = 8)
	public String get�ǵ�() {
		return this.�ǵ�;
	}

	public void set�ǵ�(String �ǵ�) {
		this.�ǵ� = �ǵ�;
	}

	@Column(name = "�����", length = 8)
	public String get�����() {
		return this.�����;
	}

	public void set�����(String �����) {
		this.����� = �����;
	}

	@Column(name = "������", length = 8)
	public String get������() {
		return this.������;
	}

	public void set������(String ������) {
		this.������ = ������;
	}

	@Column(name = "����", length = 15)
	public String get����() {
		return this.����;
	}

	public void set����(String ����) {
		this.���� = ����;
	}

	@Column(name = "����", length = 15)
	public String get����() {
		return this.����;
	}

	public void set����(String ����) {
		this.���� = ����;
	}

	@Column(name = "������", length = 8)
	public String get������() {
		return this.������;
	}

	public void set������(String ������) {
		this.������ = ������;
	}

	@Column(name = "������", length = 8)
	public String get������() {
		return this.������;
	}

	public void set������(String ������) {
		this.������ = ������;
	}

	@Column(name = "��", length = 8)
	public String get��() {
		return this.��;
	}

	public void set��(String ��) {
		this.�� = ��;
	}

	@Column(name = "����", length = 8)
	public String get����() {
		return this.����;
	}

	public void set����(String ����) {
		this.���� = ����;
	}

	@Column(name = "���", length = 8)
	public String get���() {
		return this.���;
	}

	public void set���(String ���) {
		this.��� = ���;
	}

	@Column(name = "���", length = 8)
	public String get���() {
		return this.���;
	}

	public void set���(String ���) {
		this.��� = ���;
	}

	@Column(name = "��ӯdong", length = 15)
	public String get��ӯdong() {
		return this.��ӯdong;
	}

	public void set��ӯdong(String ��ӯdong) {
		this.��ӯdong = ��ӯdong;
	}

	@Column(name = "�ܽ��", length = 15)
	public String get�ܽ��() {
		return this.�ܽ��;
	}

	public void set�ܽ��(String �ܽ��) {
		this.�ܽ�� = �ܽ��;
	}

	@Column(name = "�����", length = 8)
	public String get�����() {
		return this.�����;
	}

	public void set�����(String �����) {
		this.����� = �����;
	}

	@Column(name = "��ͨ�ɱ�", length = 18)
	public String get��ͨ�ɱ�() {
		return this.��ͨ�ɱ�;
	}

	public void set��ͨ�ɱ�(String ��ͨ�ɱ�) {
		this.��ͨ�ɱ� = ��ͨ�ɱ�;
	}

	@Column(name = "������ҵ", length = 10)
	public String get������ҵ() {
		return this.������ҵ;
	}

	public void set������ҵ(String ������ҵ) {
		this.������ҵ = ������ҵ;
	}

	@Column(name = "����", length = 8)
	public String get����() {
		return this.����;
	}

	public void set����(String ����) {
		this.���� = ����;
	}

	@Column(name = "����", length = 8)
	public String get����() {
		return this.����;
	}

	public void set����(String ����) {
		this.���� = ����;
	}

	@Column(name = "ί����", length = 8)
	public String getί����() {
		return this.ί����;
	}

	public void setί����(String ί����) {
		this.ί���� = ί����;
	}

	@Column(name = "����", length = 15)
	public String get����() {
		return this.����;
	}

	public void set����(String ����) {
		this.���� = ����;
	}

	@Column(name = "����", length = 15)
	public String get����() {
		return this.����;
	}

	public void set����(String ����) {
		this.���� = ����;
	}

	@Column(name = "�����", length = 8)
	public String get�����() {
		return this.�����;
	}

	public void set�����(String �����) {
		this.����� = �����;
	}

	@Column(name = "ί����", length = 10)
	public String getί����() {
		return this.ί����;
	}

	public void setί����(String ί����) {
		this.ί���� = ί����;
	}

	@Column(name = "����һ", length = 10)
	public String get����һ() {
		return this.����һ;
	}

	public void set����һ(String ����һ) {
		this.����һ = ����һ;
	}

	@Column(name = "����һ", length = 10)
	public String get����һ() {
		return this.����һ;
	}

	public void set����һ(String ����һ) {
		this.����һ = ����һ;
	}

	@Column(name = "���һ", length = 8)
	public String get���һ() {
		return this.���һ;
	}

	public void set���һ(String ���һ) {
		this.���һ = ���һ;
	}

	@Column(name = "����һ", length = 8)
	public String get����һ() {
		return this.����һ;
	}

	public void set����һ(String ����һ) {
		this.����һ = ����һ;
	}

	@Column(name = "���۶�", length = 8)
	public String get���۶�() {
		return this.���۶�;
	}

	public void set���۶�(String ���۶�) {
		this.���۶� = ���۶�;
	}

	@Column(name = "������", length = 10)
	public String get������() {
		return this.������;
	}

	public void set������(String ������) {
		this.������ = ������;
	}

	@Column(name = "��۶�", length = 8)
	public String get��۶�() {
		return this.��۶�;
	}

	public void set��۶�(String ��۶�) {
		this.��۶� = ��۶�;
	}

	@Column(name = "������", length = 10)
	public String get������() {
		return this.������;
	}

	public void set������(String ������) {
		this.������ = ������;
	}

	@Column(name = "�����", length = 8)
	public String get�����() {
		return this.�����;
	}

	public void set�����(String �����) {
		this.����� = �����;
	}

	@Column(name = "������", length = 10)
	public String get������() {
		return this.������;
	}

	public void set������(String ������) {
		this.������ = ������;
	}

	@Column(name = "������", length = 8)
	public String get������() {
		return this.������;
	}

	public void set������(String ������) {
		this.������ = ������;
	}

	@Column(name = "������", length = 10)
	public String get������() {
		return this.������;
	}

	public void set������(String ������) {
		this.������ = ������;
	}

	@Column(name = "��ͨ��ֵ", length = 15)
	public String get��ͨ��ֵ() {
		return this.��ͨ��ֵ;
	}

	public void set��ͨ��ֵ(String ��ͨ��ֵ) {
		this.��ͨ��ֵ = ��ͨ��ֵ;
	}

	@Column(name = "AB������ֵ", length = 15)
	public String getAb������ֵ() {
		return this.ab������ֵ;
	}

	public void setAb������ֵ(String ab������ֵ) {
		this.ab������ֵ = ab������ֵ;
	}

	@Column(name = "���ƽ��", length = 8)
	public String get���ƽ��() {
		return this.���ƽ��;
	}

	public void set���ƽ��(String ���ƽ��) {
		this.���ƽ�� = ���ƽ��;
	}

	@Column(name = "��ͷ����", length = 8)
	public String get��ͷ����() {
		return this.��ͷ����;
	}

	public void set��ͷ����(String ��ͷ����) {
		this.��ͷ���� = ��ͷ����;
	}

	@Column(name = "��ͷֹ��", length = 8)
	public String get��ͷֹ��() {
		return this.��ͷֹ��;
	}

	public void set��ͷֹ��(String ��ͷֹ��) {
		this.��ͷֹ�� = ��ͷֹ��;
	}

	@Column(name = "��ͷ�ز�", length = 8)
	public String get��ͷ�ز�() {
		return this.��ͷ�ز�;
	}

	public void set��ͷ�ز�(String ��ͷ�ز�) {
		this.��ͷ�ز� = ��ͷ�ز�;
	}

	@Column(name = "��ͷֹ��", length = 8)
	public String get��ͷֹ��() {
		return this.��ͷֹ��;
	}

	public void set��ͷֹ��(String ��ͷֹ��) {
		this.��ͷֹ�� = ��ͷֹ��;
	}

	@Column(name = "ǿ������", length = 8)
	public String getǿ������() {
		return this.ǿ������;
	}

	public void setǿ������(String ǿ������) {
		this.ǿ������ = ǿ������;
	}

	@Column(name = "��Ծ��", length = 8)
	public String get��Ծ��() {
		return this.��Ծ��;
	}

	public void set��Ծ��(String ��Ծ��) {
		this.��Ծ�� = ��Ծ��;
	}

	@Column(name = "ÿ�ʾ���", length = 8)
	public String getÿ�ʾ���() {
		return this.ÿ�ʾ���;
	}

	public void setÿ�ʾ���(String ÿ�ʾ���) {
		this.ÿ�ʾ��� = ÿ�ʾ���;
	}

	@Column(name = "ÿ�ʻ���", length = 8)
	public String getÿ�ʻ���() {
		return this.ÿ�ʻ���;
	}

	public void setÿ�ʻ���(String ÿ�ʻ���) {
		this.ÿ�ʻ��� = ÿ�ʻ���;
	}

	@Column(name = "��������", length = 10)
	public String get��������() {
		return this.��������;
	}

	public void set��������(String ��������) {
		this.�������� = ��������;
	}

	@Column(name = "��������", length = 10)
	public String get��������() {
		return this.��������;
	}

	public void set��������(String ��������) {
		this.�������� = ��������;
	}

	@Column(name = "�ܹɱ�wan", length = 15)
	public String get�ܹɱ�wan() {
		return this.�ܹɱ�wan;
	}

	public void set�ܹɱ�wan(String �ܹɱ�wan) {
		this.�ܹɱ�wan = �ܹɱ�wan;
	}

	@Column(name = "���ҹ�", length = 15)
	public String get���ҹ�() {
		return this.���ҹ�;
	}

	public void set���ҹ�(String ���ҹ�) {
		this.���ҹ� = ���ҹ�;
	}

	@Column(name = "����ͬ��", length = 15)
	public String get����ͬ��() {
		return this.����ͬ��;
	}

	public void set����ͬ��(String ����ͬ��) {
		this.����ͬ�� = ����ͬ��;
	}

	@Column(name = "����ͬ��", length = 15)
	public String get����ͬ��() {
		return this.����ͬ��;
	}

	public void set����ͬ��(String ����ͬ��) {
		this.����ͬ�� = ����ͬ��;
	}

	@Column(name = "B�ɻ�A", length = 10)
	public String getB�ɻ�a() {
		return this.b�ɻ�a;
	}

	public void setB�ɻ�a(String b�ɻ�a) {
		this.b�ɻ�a = b�ɻ�a;
	}

	@Column(name = "H��", length = 15)
	public String getH��() {
		return this.h��;
	}

	public void setH��(String h��) {
		this.h�� = h��;
	}

	@Column(name = "ְ����", length = 8)
	public String getְ����() {
		return this.ְ����;
	}

	public void setְ����(String ְ����) {
		this.ְ���� = ְ����;
	}

	@Column(name = "���ʲ�wan", length = 15)
	public String get���ʲ�wan() {
		return this.���ʲ�wan;
	}

	public void set���ʲ�wan(String ���ʲ�wan) {
		this.���ʲ�wan = ���ʲ�wan;
	}

	@Column(name = "�����ʲ�", length = 15)
	public String get�����ʲ�() {
		return this.�����ʲ�;
	}

	public void set�����ʲ�(String �����ʲ�) {
		this.�����ʲ� = �����ʲ�;
	}

	@Column(name = "�̶��ʲ�", length = 15)
	public String get�̶��ʲ�() {
		return this.�̶��ʲ�;
	}

	public void set�̶��ʲ�(String �̶��ʲ�) {
		this.�̶��ʲ� = �̶��ʲ�;
	}

	@Column(name = "�����ʲ�", length = 15)
	public String get�����ʲ�() {
		return this.�����ʲ�;
	}

	public void set�����ʲ�(String �����ʲ�) {
		this.�����ʲ� = �����ʲ�;
	}

	@Column(name = "����Ͷ��", length = 15)
	public String get����Ͷ��() {
		return this.����Ͷ��;
	}

	public void set����Ͷ��(String ����Ͷ��) {
		this.����Ͷ�� = ����Ͷ��;
	}

	@Column(name = "������ծ", length = 15)
	public String get������ծ() {
		return this.������ծ;
	}

	public void set������ծ(String ������ծ) {
		this.������ծ = ������ծ;
	}

	@Column(name = "���ڸ�ծ", length = 15)
	public String get���ڸ�ծ() {
		return this.���ڸ�ծ;
	}

	public void set���ڸ�ծ(String ���ڸ�ծ) {
		this.���ڸ�ծ = ���ڸ�ծ;
	}

	@Column(name = "������", length = 15)
	public String get������() {
		return this.������;
	}

	public void set������(String ������) {
		this.������ = ������;
	}

	@Column(name = "ÿ�ɹ���", length = 8)
	public String getÿ�ɹ���() {
		return this.ÿ�ɹ���;
	}

	public void setÿ�ɹ���(String ÿ�ɹ���) {
		this.ÿ�ɹ��� = ÿ�ɹ���;
	}

	@Column(name = "���ʲ�", length = 15)
	public String get���ʲ�() {
		return this.���ʲ�;
	}

	public void set���ʲ�(String ���ʲ�) {
		this.���ʲ� = ���ʲ�;
	}

	@Column(name = "��Ӫ����", length = 15)
	public String get��Ӫ����() {
		return this.��Ӫ����;
	}

	public void set��Ӫ����(String ��Ӫ����) {
		this.��Ӫ���� = ��Ӫ����;
	}

	@Column(name = "��Ӫ����", length = 15)
	public String get��Ӫ����() {
		return this.��Ӫ����;
	}

	public void set��Ӫ����(String ��Ӫ����) {
		this.��Ӫ���� = ��Ӫ����;
	}

	@Column(name = "�о���", length = 8)
	public String get�о���() {
		return this.�о���;
	}

	public void set�о���(String �о���) {
		this.�о��� = �о���;
	}

	@Column(name = "Ӫҵ����", length = 15)
	public String getӪҵ����() {
		return this.Ӫҵ����;
	}

	public void setӪҵ����(String Ӫҵ����) {
		this.Ӫҵ���� = Ӫҵ����;
	}

	@Column(name = "Ͷ������", length = 15)
	public String getͶ������() {
		return this.Ͷ������;
	}

	public void setͶ������(String Ͷ������) {
		this.Ͷ������ = Ͷ������;
	}

	@Column(name = "��Ӫ�ֽ���", length = 15)
	public String get��Ӫ�ֽ���() {
		return this.��Ӫ�ֽ���;
	}

	public void set��Ӫ�ֽ���(String ��Ӫ�ֽ���) {
		this.��Ӫ�ֽ��� = ��Ӫ�ֽ���;
	}

	@Column(name = "���ֽ���", length = 15)
	public String get���ֽ���() {
		return this.���ֽ���;
	}

	public void set���ֽ���(String ���ֽ���) {
		this.���ֽ��� = ���ֽ���;
	}

	@Column(name = "���", length = 15)
	public String get���() {
		return this.���;
	}

	public void set���(String ���) {
		this.��� = ���;
	}

	@Column(name = "�����ܶ�", length = 15)
	public String get�����ܶ�() {
		return this.�����ܶ�;
	}

	public void set�����ܶ�(String �����ܶ�) {
		this.�����ܶ� = �����ܶ�;
	}

	@Column(name = "˰������", length = 15)
	public String get˰������() {
		return this.˰������;
	}

	public void set˰������(String ˰������) {
		this.˰������ = ˰������;
	}

	@Column(name = "������", length = 15)
	public String get������() {
		return this.������;
	}

	public void set������(String ������) {
		this.������ = ������;
	}

	@Column(name = "δ������", length = 15)
	public String getδ������() {
		return this.δ������;
	}

	public void setδ������(String δ������) {
		this.δ������ = δ������;
	}

	@Column(name = "ÿ�ɾ���", length = 8)
	public String getÿ�ɾ���() {
		return this.ÿ�ɾ���;
	}

	public void setÿ�ɾ���(String ÿ�ɾ���) {
		this.ÿ�ɾ��� = ÿ�ɾ���;
	}

	@Column(name = "��������", length = 8)
	public String get��������() {
		return this.��������;
	}

	public void set��������(String ��������) {
		this.�������� = ��������;
	}

	@Column(name = "������", length = 10)
	public String get������() {
		return this.������;
	}

	public void set������(String ������) {
		this.������ = ������;
	}

	@Column(name = "ÿ��δ����", length = 8)
	public String getÿ��δ����() {
		return this.ÿ��δ����;
	}

	public void setÿ��δ����(String ÿ��δ����) {
		this.ÿ��δ���� = ÿ��δ����;
	}

	@Column(name = "ÿ������", length = 10)
	public String getÿ������() {
		return this.ÿ������;
	}

	public void setÿ������(String ÿ������) {
		this.ÿ������ = ÿ������;
	}

	@Column(name = "Ȩ�����", length = 8)
	public String getȨ�����() {
		return this.Ȩ�����;
	}

	public void setȨ�����(String Ȩ�����) {
		this.Ȩ����� = Ȩ�����;
	}

	@Column(name = "����", length = 15)
	public String get����() {
		return ����;
	}

	public void set����(String ����) {
		this.���� = ����;
	}

	@Column(name = "����", length = 15)
	public String get����() {
		return ����;
	}

	public void set����(String ����) {
		this.���� = ����;
	}

	@Column(name = "�ɽ���", length = 15)
	public String get�ɽ���() {
		return �ɽ���;
	}

	public void set�ɽ���(String �ɽ���) {
		this.�ɽ��� = �ɽ���;
	}

	@Column(name = "�ɽ���", length = 15)
	public String get�ɽ���() {
		return �ɽ���;
	}

	
	public void set�ɽ���(String �ɽ���) {
		this.�ɽ��� = �ɽ���;
	}
	
	
	

}