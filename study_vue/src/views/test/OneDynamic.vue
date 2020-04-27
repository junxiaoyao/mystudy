<template>
  <div id="main" @click.self="showMessage" style="background-color: #99a9bf;width: 200px;height: 200px;position: absolute;" @mousedown.stop="move">
    {{positionX}}
    {{positionY}}
  </div>
</template>

<script>
  let echarts=require('echarts');
  export default {
    name: "OneDynamic",
    data(){
      return {
        positionX:0,
        positionY:0,
      }
    },
    mounted(){
      var myChart = echarts.init(document.getElementById('main'));
      myChart.setOption({
        title: {
          text: 'ECharts 入门示例'
        },
        tooltip: {},
        xAxis: {
          data: ['衬衫', '羊毛衫', '雪纺衫', '裤子', '高跟鞋', '袜子']
        },
        yAxis: {},
        series: [{
          name: '销量',
          type: 'bar',
          data: [5, 20, 36, 10, 10, 20]
        }]
      });
    },
    methods:{
      move(e){
        let odiv = e.target;        //获取目标元素
        //算出鼠标相对元素的位置
        let disX = e.clientX - odiv.offsetLeft;
        let disY = e.clientY - odiv.offsetTop;
        document.onmousemove = (e)=>{       //鼠标按下并移动的事件
          //用鼠标的位置减去鼠标相对元素的位置，得到元素的位置
          let left = e.clientX - disX;
          let top = e.clientY - disY;
          //绑定元素位置到positionX和positionY上面
          this.positionX = top;
          this.positionY = left;
          //移动当前元素
          odiv.style.left = left + 'px';
          odiv.style.top = top + 'px';
        };
        document.onmouseup = (e) => {
          document.onmousemove = null;
          document.onmouseup = null;
        };
      },
      showMessage(){
        this.$message.success("ok")
      }
    },
  }
</script>

<style scoped>

</style>
