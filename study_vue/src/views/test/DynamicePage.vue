<template>
   <div style="width: 1000px;height: 500px;background-color: #333333;position: relative;float: left">
        <div style="background-color: #99a9bf;width: 200px;height: 200px;position: absolute;" @mousedown.stop="move">
          {{positionX}}
          {{positionY}}
        </div>
     <div style="background-color: #0e94bf;width: 200px;height: 200px;position: absolute;" @mousedown.stop="move">
       {{positionX}}
       {{positionY}}
     </div>
     <div style="background-color: #0e94bf;width: 200px;height: 200px;position: absolute;" @mousedown.stop="move">
       {{positionX}}
       {{positionY}}
     </div>
   </div>
</template>

<script>
  export default {
      name: "DynamicePage",
    data(){
        return {
            positionX:0,
            positionY:0,
        }
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
      }

    },
  }
</script>

<style scoped>

</style>
