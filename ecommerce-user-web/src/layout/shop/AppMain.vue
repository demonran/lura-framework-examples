<template>
    <div class="app-main">
      <router-view :key="key"/>
    </div>
</template>

<script>
import {computed} from "vue";
import {useRoute} from "vue-router";

export default {
  name: "AppMain",
  setup() {
    const route = useRoute()
    const key = computed(() => route.path)
    return {
      key
    }
  }
}
</script>

<style lang="scss" scoped>
.app-main {
  height: 100%;
}

</style>
