<template>
  <el-row style="width: 1000px;height: 600px;background-color: #B3C0D1">
    <el-col :span="6" style="background-color: #2c3e50;height: 600px">
      <el-button v-for="(item,index) in nodes" @click="addNode(item)" :key="index">{{ item }}</el-button>

      <el-checkbox-group v-model="checkedNodes" @change="handleCheckedCitiesChange">
        <el-checkbox v-for="item in nodes" :label="item" :key="item">{{item}}</el-checkbox>
      </el-checkbox-group>
      <el-input v-model="lineLabel"></el-input>
      <el-button @click="addLine">连线</el-button>
    </el-col>
    <el-col :span="18" style="background-color: #36353b;height: 600px" id="test-ec">

    </el-col>
  </el-row>
</template>

<script>
  let option = {
    title: {
      text: '测试关系图'
    },
    series: [
      {
        type: 'graph',
        layout: 'force',
        force: {
          repulsion: 400,
          edgeLength: 400
        },
        roam: true,
        draggable: true,
        symbolSize: 60,
        edgeSymbol: ['circle', 'arrow'],
        data: [
          {
            name: '1',
            value: 10,
            label: {
              show: true
            },
            symbolRotate: 0.5
          },
          {
            name: '2',
            value: 10,
            label: {
              show: true
            },
          },
          {
            name: '3',
            label: {
              show: true
            },
            value: 10
          },
        ],
        links: [
          {
            source: 1,
            target: 0
          },
          {
            source: 1,
            target: 2
          },
          {
            source: 0,
            target: 2
          }
        ]
      }
    ]
  };
  ;
  export default {
    name: "TestEchartsGraph",
    data() {
      return {
        nodes: [
        ],
        lineLabel:'',
        checkedNodes: [],
        myChart: {},
      }

    },
    methods: {
      addLine() {
        console.log(this.checkedNodes);
        let line = {
          source: this.checkedNodes[0],
          target: this.checkedNodes[1],
          label:{
            show:true,
            formatter:this.lineLabel
          }
        };
        option.series[0].links.push(line);
        this.myChart.setOption(option);
      },
      addNode(node) {
        this.$message.success(node);
        option.series[0].data.push({
          name: node, x: 200, y: 200, label: {
            show: true
          },
        });
        this.myChart.setOption(option);
      },
      handleCheckedCitiesChange(value) {
        let checkedCount = value.length;
        if (checkedCount > 2) {
          this.$message.error("选择两个点连线");
        }
      }
    },
    mounted() {
      this.myChart = this.$echarts.init(document.getElementById('test-ec'));
      this.myChart.setOption(option);
      for(let i=0;i<10;i++){
        this.nodes.push('test'+i);
      }
    }
  }
</script>

<style scoped>

</style>
