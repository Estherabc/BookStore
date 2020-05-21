package gcweb;

import java.util.ArrayList;

public class ShopCar {
	private ArrayList buylist=new ArrayList();
	public ArrayList getBuylist(){
		return buylist;
	}
	public void addItem(GoodsSingle single){
		if(single!=null){
			if(buylist.size()==0){
				GoodsSingle temp=new GoodsSingle();
				temp.setBookId(single.getBookId());
				temp.setBookName(single.getBookName());
				temp.setBookNum(single.getBookNum());
				temp.setBookOthNum(single.getBookOthNum());
				temp.setBookPic(single.getBookPic());
				temp.setBookPrice(single.getBookPrice());
				temp.setPublishName(single.getPublishName());
				buylist.add(temp);
			}
			else{
				int i=0;
				for(;i<buylist.size();i++){
					GoodsSingle temp=(GoodsSingle)buylist.get(i);
					if(temp.getBookName().equals(single.getBookName())){
						temp.setBookNum(temp.getBookNum()+1);
						break;
					}
				}
				if(i>=buylist.size()){
					GoodsSingle temp=new GoodsSingle();
					temp.setBookId(single.getBookId());
					temp.setBookName(single.getBookName());
					temp.setBookNum(single.getBookNum());
					temp.setBookOthNum(single.getBookOthNum());
					temp.setBookPic(single.getBookPic());
					temp.setBookPrice(single.getBookPrice());
					temp.setPublishName(single.getPublishName());
					buylist.add(temp);
				}
			}
		}
	}
	public void removelItem(String id){
		for(int i=0;i<buylist.size();i++){
			GoodsSingle temp=(GoodsSingle)buylist.get(i);
			if(temp.getBookId().equals(id)){
				if(temp.getBookNum()>1){
					temp.setBookNum(temp.getBookNum()-1);
					break;
				}
				else if(temp.getBookNum()==1){
					buylist.remove(i);
				}
			}
		}
	}
	public void clearCar(){
		buylist.clear();
	}
}
