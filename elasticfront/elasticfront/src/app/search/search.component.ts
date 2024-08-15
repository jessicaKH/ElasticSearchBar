import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent {
  query: string = '';
  results: any[] = [];
  isLoading: boolean = false;

  constructor(private http: HttpClient) {}

  search(): void {
    if (this.query.trim()) {
      this.isLoading = true;
      this.http.get<any>(`http://localhost:8080/search?query=${this.query}`)
        .subscribe(response => {
          this.results = response.hits.hits; 
          this.isLoading = false;
        });
    } else {
      this.results = [];
    }
  }
}
