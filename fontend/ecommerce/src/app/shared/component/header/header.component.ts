
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'header-section',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  categories = [
    {
        "id": 1,
        "name": "Celulares",
        "categories": [
            {
                "id": 2,
                "name": "Accesorios",
                "categories": []
            },
            {
                "id": 3,
                "name": "Celulares y Teléfonos",
                "categories": [
                    {
                        "id": 5,
                        "name": "Celular Huawei",
                        "categories": []
                    },
                    {
                        "id": 6,
                        "name": "iPhone",
                        "categories": []
                    }
                ]
            },
            {
                "id": 4,
                "name": "Wearables",
                "categories": []
            }
        ]
    }
];

    ngOnInit(): void {
        
    }
}