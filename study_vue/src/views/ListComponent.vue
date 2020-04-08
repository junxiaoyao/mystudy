<template>
  <el-row>
    <el-col :span="3">
    </el-col>
    <el-col :span="18">
      <el-table
        :data="dataList"
        style="width: 100%">
        <el-table-column
          fixed
          prop="comId"
          label="测试ID"
          width="150">
        </el-table-column>
        <el-table-column
          prop="comName"
          label="测试名"
          width="120">
        </el-table-column>
        <el-table-column
          prop="comTitle"
          label="测试标题"
          width="120">
        </el-table-column>
        <el-table-column
          prop="comInstitution"
          label="测试描述"
          width="120">
        </el-table-column>

        <el-table-column
          prop="comType"
          label="测试类型"
          width="300">
        </el-table-column>
        <el-table-column
          prop="comStart"
          label="时间"
          width="200">
        </el-table-column>

        <el-table-column
          fixed="right"
          label="操作"
          width="200">
          <template slot-scope="scope">
            <el-col :span="12">
              <el-button type="info" round size="small" @click="edit(scope.row)">编辑</el-button>
            </el-col>
            <el-col :span="12">
              <el-button type="danger" @click="del(scope.row.comId)" round size="small">删除</el-button>
            </el-col>
          </template>
        </el-table-column>
      </el-table>
    </el-col>
    <el-col :span="3">
    </el-col>
  </el-row>
</template>

<script>
  export default {
    name: "ListComponent",
    data() {
      return {}
    },
    methods: {
      edit: function (row) {
        this.$emit('edit', row);
      },
      del: function (comId) {
        this.$emit('del', comId);
      }
    },
    // props: [
    //   'dataList'
    // ]
    props: {
      dataList:Array
      // dataList: {
      //   type: Array,
      //   default() {
      //     return []
      //   }
      // }
    }
  }
</script>

<style scoped>

</style>
