package com.example.MamazonCorrection.Controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MamazonCorrection.Model.Entity.Item;
import com.example.MamazonCorrection.Service.ItemService;

@CrossOrigin("*")
@RestController
@RequestMapping("/items")
public class ItemController {
	
	private final ItemService service;

	@Autowired
	public ItemController(ItemService service)
	{
		this.service = service;
	}

	@GetMapping("/{id}")
	public Optional<Item> getItem(@PathVariable Long id)
	{
		return this.service.getItem(id);
	}

	@GetMapping
	public List<Item> getAllItem()
	{
		return service.getAllItem();
	}

	@PostMapping
	public Item createItem(@RequestBody Item user)
	{
		return service.createItem(user);
	}


	@PutMapping("/{id}")
	public Item updateItem(@RequestBody Item user, @PathVariable Long id)
	{
		return service.updateItem(user, id);
	}

	@DeleteMapping("/{id}")
	public void deleteItem(@PathVariable Long id)
	{
		service.deleteItem(id);
	}

}
