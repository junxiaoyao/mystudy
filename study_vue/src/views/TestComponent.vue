<template>
  <el-row>
    <el-col :span="24">
      <el-col :span="16">
        <el-input v-model="searchParams.comName" placeholder="查询名称"></el-input>
      </el-col>
      <el-col :span="4">
        <el-button type="info" round @click="addOne">新增数据</el-button>
      </el-col>
      <el-col :span="4">
        <el-button type="danger" @click="count">查询数据</el-button>
      </el-col>
    </el-col>
    <el-col :span="24">
      <ListComponent :dataList="this.dataList" v-on:edit="edit" @del="del">
      </ListComponent>
    </el-col>
    <el-col :span="24">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="page.pageNum"
        :page-sizes="[1, 2, 3, 4,5]"
        :page-size="page.pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="page.total">
      </el-pagination>
    </el-col>
    <el-col :span="4">
      <div class="grid-content bg-purple">
        <el-dialog title="添加新成员" :visible.sync="centerDialogVisible" width="30%" center>
          <el-form ref="form" :model="form" label-width="80px">
            <el-form-item label="ID" v-show="showId">
              <el-input disabled v-model="form.comId"></el-input>
            </el-form-item>
            <el-form-item label="名称">
              <el-input v-model="form.comName"></el-input>
            </el-form-item>
            <el-form-item label="标题">
              <el-input v-model="form.comTitle"></el-input>
            </el-form-item>
            <el-form-item label="描述">
              <el-input v-model="form.comInstitution"></el-input>
            </el-form-item>
            <el-form-item label="时间选择">
              <el-date-picker placeholder="选择时间" type="datetime" v-model="form.comStart"
                              style="width: 100%;"></el-date-picker>
            </el-form-item>

            <el-form-item label="类型">
              <el-select v-model="form.comType" placeholder="请选择类型">
                <el-option label="1" value="1"></el-option>
                <el-option label="2" value="2"></el-option>
                <el-option label="3" value="3"></el-option>
              </el-select>
            </el-form-item>
          </el-form>

          <span slot="footer" class="dialog-footer" v-show="showSave">
            <el-button @click="centerDialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="addAndUpdate">确 定</el-button>
          </span>
        </el-dialog>

      </div>
    </el-col>
  </el-row>
</template>

<script>
  import ListComponent from '@/views/ListComponent.vue'

  export default {
    name: "TestComponent",
    data() {
      return {
        dataList: [],
        componentName: 'ListComponent',
        searchParams: {
          comName: '',
          pageNum: 1,
          pageSize: 2
        },
        showId: true,
        showSave: true,
        centerDialogVisible: false,
        form: {
          comId: '',
          comName: '',
          comTitle: '',
          comInstitution: '',
          comType: '',
          comStart: ''
        },
        page: {
          pageNum: 1,
          total: 0,
          pageSize: 1
        }
      }
    },
    methods: {
      filterTag(value, row) {
        return row.tag === value;
      },
      addOne: function () {
        for (let key in this.form) {
          this.form[key] = ''
        }
        this.showId = false
        this.centerDialogVisible = true
      },
      del: function (comId) {
        this.$confirm('此操作将永久删除, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$api.get('/com/del/' + comId, this.form, response => {
            this.count()
          });
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
      },
      addAndUpdate: function () {
        if (this.form.comId > 0) {
          this.$api.post('/com/update', this.form, response => {
            this.count()
            this.centerDialogVisible = false
          });

        } else {
          this.$api.post('/com/add', this.form, response => {
            this.count()
            this.centerDialogVisible = false
          });
        }

      },
      edit(row) {
        for (let key in row) {
          this.form[key] = row[key]
        }
        this.showSave = true
        this.centerDialogVisible = true
      },

      search: function () {
        this.searchParams.pageSize = this.page.pageSize;
        this.searchParams.pageNum = this.page.pageNum;
        this.$api.get('/rest/search', this.searchParams, response => {
          if (response.status >= 200 && response.status < 300) {
            this.dataList = JSON.parse(response.data.data)
          } else {
            console.log(response);
          }
        });
      },
      count: function () {
        this.$api.get('/com/count', this.searchParams, response => {
          //this.dataList = response.data;
          if (response.status >= 200 && response.status < 300) {
            this.page.total = parseInt(response.data.data)
            if (this.page.total > 0) {
              this.page.pageNum = 1;
              this.search();
            }
          } else {
            console.log(response);
          }
        });
      },

      handleSizeChange(val) {
        this.page.pageSize = val
        this.page.pageNum = 1;
        this.search();
      },
      handleCurrentChange(val) {
        this.page.pageNum = val
        this.search();
      }
    },
    mounted() {
      this.count();
    },
    components: {
      ListComponent
    }

  }
</script>

<style scoped>

</style>
