package com.example.MamazonCorrection.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MamazonCorrection.Model.Entity.Item;
import com.example.MamazonCorrection.Model.Repository.itemRepository;

@Service
public class ItemService {
	
	private final itemRepository repo;
	
	@Autowired
	ItemService(itemRepository repo)
	{
		this.repo = repo;
	}
	
	// get by id
	public Optional<Item> getItem(Long id)
	{
		return repo.findById(id);
	}
	
	// get all
	public List<Item> getAllItem()
	{
		return repo.findAll();
	}

	// Post
	public Item createItem(Item item)
	{
		return repo.save(item);
	}
	
	
	// Update Item
	public Item updateItem(Item item, Long id)
	{
		Item bddItem = repo.findById(id).get();
		
		bddItem.setCategory(item.getCategory());
		bddItem.setName(item.getName());
		bddItem.setPhoto(item.getPhoto());
		bddItem.setPrice(item.getPrice());
		bddItem.setQuantity(item.getQuantity());

		return repo.save(bddItem);
	}
	
	// Delete Item
	public void deleteItem(Long id)
	{
		repo.deleteById(id);
	}
}
