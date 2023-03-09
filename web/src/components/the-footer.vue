<template>
  <a-layout-footer style="text-align: center">
    Zhiyi Jin -- WIKI
  </a-layout-footer>
</template>

<script lang="ts">
import { defineComponent} from 'vue';

export default defineComponent({
  name: 'the-footer',
  props: {
    msg: String,
  },
});
</script>
