<template>
  <div>
    商家模版
    <router-view :key="key" />
  </div>
</template>

<script>
export default {
  name: "shop-layout",
  computed: {
    key() {
      return this.$route.path
    }
  }
}
</script>

<style scoped>

</style>
