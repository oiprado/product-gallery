
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {
    
    ngOnInit(): void {
        
    }
    
    @Input()
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

}