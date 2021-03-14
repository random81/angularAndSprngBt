import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ItemService } from '../item.service';
import { Item } from '../item';

@Component({
  selector: 'app-item-details',
  templateUrl: './item-details.component.html',
  styleUrls: ['./item-details.component.css']
})
export class ItemDetailsComponent implements OnInit {

  itemNumber!: number;
  item: Item = new Item();
  details!: String;
  constructor(private itemService: ItemService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.itemNumber = this.route.snapshot.params['id'];
    console.log(this.itemNumber);
    this.itemService.getItemDetailsById(this.itemNumber).subscribe(data => {
      console.log(data);
      this.details = data.itemDeets;
    }, error => console.log(error));
  }

}
