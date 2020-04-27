<template>
  <div @click.self="showMessage" style="background-color: #000108;width: 400px;height: 300px;position: absolute;" @mousedown.stop="move">
    <div style="width: 400px;height: 250px;margin-top: 50px;" id="main">

    </div>
  </div>
</template>

<script>
  let option = {
    title: {
      text: 'Graph 简单示例'
    },
    tooltip: {},
    animationDurationUpdate: 1500,
    animationEasingUpdate: 'quinticInOut',
    series: [
      {
        type: 'graph',
        layout: 'none',
        symbolSize: 50,
        roam: true,
        label: {
          show: true
        },
        edgeSymbol: ['circle', 'arrow'],
        edgeSymbolSize: [4, 10],
        edgeLabel: {
          fontSize: 20
        },
        data: [{
          name: '节点1',
          x: 300,
          y: 300
        }, {
          name: '节点2',
          x: 800,
          y: 300
        }, {
          name: '节点3',
          x: 550,
          y: 100
        }, {
          name: '节点4',
          x: 550,
          y: 500
        }],
        // links: [],
        links: [{
          source: 0,
          target: 1,
          symbolSize: [5, 20],
          label: {
            show: true
          },
          lineStyle: {
            width: 5,
            curveness: 0.2
          }
        }, {
          source: '节点2',
          target: '节点1',
          label: {
            show: true
          },
          lineStyle: {
            curveness: 0.2
          }
        }, {
          source: '节点1',
          target: '节点3'
        }, {
          source: '节点2',
          target: '节点3'
        }, {
          source: '节点2',
          target: '节点4'
        }, {
          source: '节点1',
          target: '节点4'
        }],
        lineStyle: {
          opacity: 0.9,
          width: 2,
          curveness: 0
        }
      }
    ]
  };
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
      myChart.setOption(option);
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
