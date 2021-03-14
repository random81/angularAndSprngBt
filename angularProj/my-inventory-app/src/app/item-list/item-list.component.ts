import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Item } from '../item';
import { ItemService } from '../item.service';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit {

  items: Item[] = [];
  itemNumber!: number;
  amountChange!: number;
  amountDecrease!: number;
  amountIncrease!: number;
  item: Item = new Item();

  constructor(private itemService: ItemService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.getItems();
  }

  deposit(id: number, event: any) {
    const inputValue = event.target.increase.value;
    console.log(inputValue);
    this.itemService.depositItem(id, inputValue, this.item).subscribe(data => {
    }, error => console.log(error));
      window.location.reload();
  }

  withdraw(id: number, event: any) {
    const inputValue = event.target.decrease.value;
    this.itemService.withdrawItem(id, inputValue, this.item).subscribe(data => {
    }, error => console.log(error));
      window.location.reload();
  }

  private getItems() {
    this.itemService.getItemsList().subscribe(data => {
      console.log(data);
      this.items = data;
    });
  }

  itemDetails(id: number) {
    this.router.navigate(['item-details', id]);
  }

  updateItem(id: number) {
    this.router.navigate(['update-item', id]);
  }

  deleteItem(id: number) {
    this.itemService.deleteItem(id).subscribe(data => {
      console.log(data);
      this.getItems();
    })
    this.router.navigate(['/items']);
  }

  goToItemList() {
    this.router.navigate(['/items']);
  }
}
