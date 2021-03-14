import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Item } from './item';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  private baseURL ="http://localhost:8080/inventory";
  constructor(private httpClient:HttpClient) { }

  getItemsList(): Observable<Item[]> {
    return this.httpClient.get<Item[]>(`${this.baseURL}`)
  }

  createItem(item: Item): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, item);
  }

  getItemDetailsById(itemNumber: number): Observable<any>{
    return this.httpClient.get<String>(`${this.baseURL}/${itemNumber}`);
  }

  getItemById(itemNumber: number): Observable<Item>{
    return this.httpClient.get<Item>(`${this.baseURL}/item/${itemNumber}`);
  }

  updateItem(itemNumber: number, item: Item): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${itemNumber}`, item);
  }

  withdrawItem(itemNumber: number, amt: number, item: Item): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/withdraw/${itemNumber}/amount/${amt}`, item );
  }

  depositItem(itemNumber: number, amt: number, item: Item): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/deposit/${itemNumber}/amount/${amt}`, item );
  }

  deleteItem(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }

}
