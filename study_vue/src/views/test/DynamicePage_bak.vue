<template>
  <div>
   <div style="width: 1000px;height:400px;background-color: #333333;position: relative;">
     <one-dynamic></one-dynamic>
     <one-dynamic></one-dynamic>
   </div>
  </div>
</template>

<script>
  import OneDynamic from '@/views/test/OneDynamic';
  export default {
      name: "DynamicePage",
    data(){
        return{

        }
    },
    methods:{
    },
    components:{
        OneDynamic
    }

  }
</script>

<style scoped>

</style>
