package model;

import java.util.ArrayList;
import java.util.List;

import model.buildings.Building;
import model.buildings.Hospital;
import model.buildings.House;
import model.buildings.Lottery;
import model.buildings.News;
import model.buildings.Origin;
import model.buildings.Park;
import model.buildings.Point;
import model.buildings.Prison;
import model.buildings.Chance;

/**
 * ȫ�ַ�����Ϣ
 * 
 * @author MOVELIGHTS
 * 
 */
public class BuildingsModel extends Tick implements Port{
	/**
	 * ��������
	 */
	private List<Building> buildings = null;
	
	private LandModel land = null;

	
	public BuildingsModel (LandModel land){
		this.land = land;
	}


	/**
	 * 
	 * ��ʼ������
	 * 
	 */
	private void initBuilding() {
		// ��ʼ������
		buildings = new ArrayList<Building>();
		// ��Ӧ��ͼ���뷿��
		int[][] temp = this.land.getLand();
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				switch (temp[i][j]) {
				case LandModel.SPACE:
					Building tempBuidling = new House(i, j);
					// ���ÿյص�����Ϊ���Թ����
					tempBuidling.setPurchasability(true);
					buildings.add(tempBuidling);
					break;
				case LandModel.HOSPITAL:// ҽԺ
					buildings.add(new Hospital(i, j));
					//����ȫͼҽԺ��
					LandModel.hospital = new java.awt.Point(j * 60,i * 60);
//					System.out.println(LandModel.hospital );
					break;
				case LandModel.LOTTERY:
					buildings.add(new Lottery(i, j));
					break;
				case LandModel.NEWS:
					buildings.add(new News(i, j));
					break;
				case LandModel.ORIGIN:
					buildings.add(new Origin(i, j));
					break;
				case LandModel.PARK:
					buildings.add(new Park(i, j));
					break;
				case LandModel.MONEY_1000:
					buildings.add(new Point(i, j, 1000));
					break;
				case LandModel.MONEY_2000:
					buildings.add(new Point(i, j, 3000));
					break;
				case LandModel.MONEY_3000:
					buildings.add(new Point(i, j, 5000));
					break;
				case LandModel.CHANCE:
					buildings.add(new Chance(i, j));
					break;
				case LandModel.PRISON:// ����
					buildings.add(new Prison(i, j));
					//����ȫͼ������
					LandModel.prison = new java.awt.Point(j * 60, i * 60);
//					System.out.println(LandModel.prison );
					break;
				default:
					break;
				}
			}
		}
	}

	/**
	 * 
	 * ��÷��ݱ�
	 * 
	 * @return
	 */
	public List<Building> getBuilding(){
		return buildings;
	}
	/**
	 * ��ȡ��ͼ���
	 */
	public LandModel getLand() {
		return land;
	}
	/**
	 * 
	 * ��õ�ǰλ�÷���
	 * 
	 */
	public Building getBuilding(int x,int y){
		for (Building temp : this.buildings){
			if (temp.getPosX() == x && temp.getPosY() == y){
				return temp;
			}
		}
		return null;
	}
	/**
	 * 
	 * ��ʼ��Ϸ����
	 * 
	 */
	public void startGameInit (){
		// ��ʼ������
		initBuilding();
	}

	@Override
	public void updata(long tick) {
		this.nowTick = tick;
		
	}
}