import { Component, OnInit } from '@angular/core';
import { ItemService } from '../item.service';
import { Item } from '../item';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-item',
  templateUrl: './update-item.component.html',
  styleUrls: ['./update-item.component.css']
})
export class UpdateItemComponent implements OnInit {

  itemNumber!: number;
  item: Item = new Item();
  constructor(private itemService: ItemService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.itemNumber = this.route.snapshot.params['id'];
    this.itemService.getItemById(this.itemNumber).subscribe(data => {
      this.item = data;
    }, error => console.log(error));
  }

  onSubmit(){
    this.itemService.updateItem(this.itemNumber, this.item).subscribe( data =>{
      this.goToItemList();
    }
    , error => console.log(error));
    this.router.navigate(['/items']);
  }

  goToItemList(){
    this.router.navigate(['/items']);
  }

}
