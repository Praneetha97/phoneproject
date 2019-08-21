package com.niit.dao;
import java.util.List;
import com.niit.bean.*;


public interface ModelDao 
{
	public boolean addModel(Model model);
	   public boolean deleteModel(Model model);
	   public boolean updateModel(Model  model);
	   public List<Model> listModel();
	   public Model getModel(int ModelId);

	
	
	

}
