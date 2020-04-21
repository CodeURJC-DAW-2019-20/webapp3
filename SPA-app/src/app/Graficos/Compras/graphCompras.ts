import { Component, OnInit } from '@angular/core';
import { ChartOptions, ChartType, ChartDataSets } from 'chart.js';
import { Label } from 'ng2-charts';
import { TransactionService } from 'src/app/transaction/app.transactionService';
import { DataService } from 'src/app/Data/app.dataService';

@Component({
  selector: 'app-Compras',
  templateUrl: './graphCompras.html'
})
export class GraphCompras implements OnInit {

  constructor(private transactioinService: TransactionService, public dataservice:DataService) { }
  fechas: string[];
  cantidades:string[];
  valores:number[]=[0];
  fech:Label[]=['Ref'];


  ngOnInit(): void {
    this.getValues()
  }

    getValues(){
      this.transactioinService.getTransaction(this.dataservice.user.name,this.dataservice.user.passwordHash).subscribe(
        response => {
            this.fechas=response[0].split(',');
            this.cantidades=response[1].split(',');
            this.cantidades.forEach(element => {
              this.valores.push(Number.parseInt(element));
              console.log('rer');
            });
            this.fechas.forEach(element => {
              this.fech.push(element)
            });
            
            console.log(response);
        },
        error => console.log('Error al solicitar el stock')
      );
    }

  public barChartOptions: ChartOptions = {
    responsive: true,
    // We use these empty structures as placeholders for dynamic theming.
    scales: { xAxes: [{}], yAxes: [{}] },
    plugins: {
      datalabels: {
        anchor: 'end',
        align: 'end',
      }
    }
  };
  public barChartLabels: Label[] = this.fech;
  public barChartType: ChartType = 'bar';
  public barChartLegend = true;


  public barChartData: ChartDataSets[] = [
    { data: this.valores, label: 'COMPRAS' },
  ];

  // events
  public chartClicked({ event, active }: { event: MouseEvent, active: {}[] }): void {
    console.log(event, active);
  }

  public chartHovered({ event, active }: { event: MouseEvent, active: {}[] }): void {
    console.log(event, active);
  }

  public randomize(): void {
    // Only Change 3 values
    const data = [
      Math.round(Math.random() * 100),
      59,
      80,
      (Math.random() * 100),
      56,
      (Math.random() * 100),
      40];
    this.barChartData[0].data = data;
  }

}
