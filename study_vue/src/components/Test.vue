<template>
  <el-row>
    <el-col :span="6">
      <div class="grid-content bg-purple"></div>
    </el-col>
    <el-col :span="6">
      <div class="grid-content bg-purple">
        <el-input v-model="name" placeholder="请输入名称"></el-input>
      </div>
    </el-col>
    <el-col :span="6">
      <div class="grid-content bg-purple">
        <el-button type="primary" @click="centerDialogVisible = true,index='',showSave=true">添加</el-button>
      </div>
    </el-col>
    <el-col :span="6">
      <div class="grid-content bg-purple"></div>
    </el-col>
    <el-col :span="4">
      <div class="grid-content bg-purple"></div>
    </el-col>
    <el-col :span="16">
      <div class="grid-content bg-purple-light">
        <el-table
          :data="tableData.filter(data => !name || data.name.toLowerCase().includes(name.toLowerCase()))"
          border
          style="width: 100%">
          <el-table-column
            fixed
            prop="date"
            label="日期"
            width="150">
          </el-table-column>
          <el-table-column
            prop="name"
            label="姓名"
            width="120">
          </el-table-column>
          <el-table-column
            prop="province"
            label="省份"
            width="120">
          </el-table-column>
          <el-table-column
            prop="city"
            label="市区"
            width="120">
          </el-table-column>
          <el-table-column
            prop="address"
            label="地址"
            width="300">
          </el-table-column>
          <el-table-column
            prop="zip"
            label="邮编"
            width="120">
          </el-table-column>
          <el-table-column
            prop="times"
            label="时间"
            width="120">
          </el-table-column>

          <el-table-column
            fixed="right"
            label="操作"
            width="100">

            <template slot-scope="scope">
              <el-button @click="handleClick(scope.row,scope)" type="text" size="small">查看</el-button>
              <el-button type="text" size="small" @click="edit(scope.$index,scope.row)">编辑</el-button>
              <el-button type="text" @click="deletClick(scope.$index,scope.row)" size="small">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
    </el-col>
    <el-col :span="4">
      <div class="grid-content bg-purple">
        <el-dialog title="添加新成员" :visible.sync="centerDialogVisible" width="30%" center>
          <el-form ref="form" :model="form" label-width="80px">
            <el-form-item label="姓名">
              <el-input v-model="form.name"></el-input>
            </el-form-item>
            <el-form-item label="邮编">
              <el-input v-model="form.zip"></el-input>
            </el-form-item>


            <el-form-item label="时间选择">
              <el-col :span="11">
                <el-date-picker type="date" placeholder="选择日期" v-model="form.date"
                                style="width: 100%;"></el-date-picker>
              </el-col>
              <el-col class="line" :span="2">-</el-col>
              <el-col :span="11">
                <el-time-picker placeholder="选择时间" v-model="form.times" style="width: 100%;"></el-time-picker>
              </el-col>
            </el-form-item>

            <el-form-item label="省份及市区">
              <el-select v-model="form.province" placeholder="请选择活动区域">
                <el-option label="上海" value="上海"></el-option>
                <el-option label="北京" value="北京"></el-option>
              </el-select>
              <el-select v-model="form.city" placeholder="请选择市区">
                <el-option label="A区" value="A区"></el-option>
                <el-option label="B区" value="B区"></el-option>
              </el-select>
            </el-form-item>

            <el-form-item label="地址">
              <el-input v-model="form.address"></el-input>
            </el-form-item>

          </el-form>

          <span slot="footer" class="dialog-footer" v-show="showSave">
            <el-button @click="centerDialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="addOne">确 定</el-button>
          </span>
        </el-dialog>
      </div>
    </el-col>
  </el-row>

</template>

<script>
  export default {
    name: 'test',
    methods: {
      handleClick(row, scope) {

        console.log(this.$store.state.count)
        console.log(scope)
        for (let key in row) {
          this.form[key] = row[key]
        }
        this.showSave = false
        this.centerDialogVisible = true
      },
      edit(index, row) {
        for (let key in row) {
          this.form[key] = row[key]
        }
        this.index = parseInt(index)
        this.showSave = true
        this.centerDialogVisible = true
      },
      deletClick(index, row) {
        this.tableData.splice(index, 1)
      },
      addOne: function () {
        let form = {}
        for (let key in this.form) {
          form[key] = this.form[key]
        }
        if (this.index === '') {
          this.tableData.push(form)
        } else {
          let exitForm = this.tableData[this.index]
          for (let key in this.form) {
            exitForm[key] = this.form[key]
          }
        }

        for (let key in this.form) {
          this.form[key] = ''
        }
        this.centerDialogVisible = false
      }
    },
    data() {
      return {
        tableData: [
          {
            date: '2016-05-02',
            name: '王小虎',
            province: '上海',
            city: '普陀区',
            address: '上海市普陀区金沙江路 1518 弄',
            zip: 200333,
            times: (new Date().getTime()).toLocaleString()
          }, {
            date: '2016-05-04',
            name: '王小虎',
            province: '上海',
            city: '普陀区',
            address: '上海市普陀区金沙江路 1517 弄',
            zip: 200333,
            times: ((new Date().getTime()).toLocaleString()).toLocaleString()

          }, {
            date: '2016-05-01',
            name: '王小虎',
            province: '上海',
            city: '普陀区',
            address: '上海市普陀区金沙江路 1519 弄',
            zip: 200333,
            times: (new Date().getTime()).toLocaleString()
          }, {
            date: '2016-05-03',
            name: '王小虎',
            province: '上海',
            city: '普陀区',
            address: '上海市普陀区金沙江路 1516 弄',
            zip: 200333,
            times: (new Date().getTime()).toLocaleString()
          }],
        name: '',
        showSave: false,
        centerDialogVisible: false,
        index: '',
        form: {
          date: '2016-05-04',
          name: '王小虎',
          province: '上海',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1517 弄',
          zip: 200333,
          times: new Date().getTime()
        }
      }
    }
  }
</script>

<style scoped>
  .el-row {
    margin-bottom: 20px;

  &
  :last-child {
    margin-bottom: 0;
  }

  }
  .el-col {
    border-radius: 4px;
  }

  .bg-purple-dark {
    background: #99a9bf;
  }

  .bg-purple {
    background: #d3dce6;
  }

  .bg-purple-light {
    background: #e5e9f2;
  }

  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }

  .row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
  }
</style>
